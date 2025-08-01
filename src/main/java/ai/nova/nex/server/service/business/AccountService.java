package ai.nova.nex.server.service.business;

import ai.nova.nex.server.dto.SysUserDTO;
import ai.nova.nex.server.entity.model.RegisterUserModel;

import java.util.List;

/**
 * @author 小正
 * @date 2025年07月29日 19:59
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 账户服务
 */
public interface AccountService {
    boolean register(RegisterUserModel registerUserModel);
    boolean login(String username, String password);
    boolean login(SysUserDTO sysUserDTO, String password);
    List<String> getUserRoleCodes(Long userId);
    List<String> getUserPermissionCodes(Long userId);
    List<String> getUserTemporaryPermissions(Long userId);
}
