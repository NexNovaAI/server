package ai.nova.nex.server.service.business.i;

import ai.nova.nex.server.dto.SysTemporaryPermissionsDTO;
import ai.nova.nex.server.dto.SysUserDTO;
import ai.nova.nex.server.dto.SysUserRoleDTO;
import ai.nova.nex.server.entity.model.RegisterUserModel;
import ai.nova.nex.server.enums.OTPStatusEnum;
import ai.nova.nex.server.enums.UserStatusEnum;
import ai.nova.nex.server.exception.BusinessException;
import ai.nova.nex.server.lock.DistributedLock;
import ai.nova.nex.server.lock.ZLock;
import ai.nova.nex.server.service.business.AccountService;
import ai.nova.nex.server.service.db.*;
import ai.nova.nex.server.service.system.SystemAESService;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 小正
 * @date 2025年07月29日 19:59
 * @Description 请填写此类描述
 */
@Service
@Slf4j
public class IAccountService implements AccountService {


    @Resource
    private SysUserService SysUserService;
    @Resource
    private SystemAESService SystemAESService;
    @Resource
    private SysUserRoleService SysUserRoleService;
    @Resource
    private SysPermissionsService SysPermissionsService;
    @Resource
    private SysTemporaryPermissionsService SysTemporaryPermissionsService;
    @Resource
    private SysRolePermissionService SysRolePermissionService;

    @Override
    public boolean register(RegisterUserModel registerUserModel) {
        // todo 邮箱验证码效验

        SysUserDTO sysUserDTO = SysUserService.getUserByUsername(registerUserModel.getUsername());
        if (ObjectUtil.isNotNull(sysUserDTO)) {
            throw new BusinessException("此用户已存在");
        }
        sysUserDTO = new SysUserDTO();
        sysUserDTO.setUsername(registerUserModel.getUsername());
        sysUserDTO.setPassword(SecureUtil.md5().digestHex(registerUserModel.getPassword()));
        sysUserDTO.setMailbox(registerUserModel.getMailbox());
        sysUserDTO.setOtpStatus(OTPStatusEnum.NOT_ENABLED);
        sysUserDTO.setRegisterAddress(registerUserModel.getRegisterAddress());
        sysUserDTO.setUserStatus(UserStatusEnum.NORMAL);
        sysUserDTO.setSuperAdmin(false);
        try {
            return SysUserService.save(sysUserDTO);
        } catch (Exception e) {
            log.error("用户保存失败", e);
            throw new BusinessException("注册失败, 请联系管理员");
        }

    }

    @Override
    public boolean login(String username, String password) {
        SysUserDTO user = SysUserService.getUserByUsername(username);
        return !ObjectUtil.isNull(user) && SecureUtil.md5().digestHex(password).equals(user.getPassword());
    }

    @Override
    public boolean login(SysUserDTO sysUserDTO, String password) {
        return !ObjectUtil.isNull(sysUserDTO) && SecureUtil.md5().digestHex(password).equals(sysUserDTO.getPassword());
    }

    @Override
    public List<String> getUserRoleCodes(Long userId) {
        return SysUserRoleService.getByUserId(userId).getRoleCodes();
    }

    @Override
    public List<String> getUserPermissionCodes(Long userId) {
        return SysRolePermissionService.getPermissionCodes(getUserRoleCodes(userId));
    }

    @Override
    public List<String> getUserTemporaryPermissions(Long userId) {
        List<SysTemporaryPermissionsDTO> sysTemporaryPermission = SysTemporaryPermissionsService.getByUserId(userId, true);
        return sysTemporaryPermission.stream()
                .map(SysTemporaryPermissionsDTO::getPermissionCodes)
                .flatMap(List::stream)
                .distinct()
                .toList();
    }
}
