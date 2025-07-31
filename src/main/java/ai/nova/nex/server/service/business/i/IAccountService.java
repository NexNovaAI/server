package ai.nova.nex.server.service.business.i;

import ai.nova.nex.server.dto.SysUserDTO;
import ai.nova.nex.server.entity.model.RegisterUserModel;
import ai.nova.nex.server.service.business.AccountService;
import ai.nova.nex.server.service.db.SysUserService;
import ai.nova.nex.server.service.system.SystemAESService;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean register(RegisterUserModel registerUserModel) {
        return false;
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
}
