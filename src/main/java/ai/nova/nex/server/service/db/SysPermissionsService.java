package ai.nova.nex.server.service.db;

import ai.nova.nex.server.config.base.SuperService;
import ai.nova.nex.server.dto.SysPermissionsDTO;

/**
 * @author 小正
 * @date 2025年08月01日 11:11
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SysPermissionsService extends SuperService<SysPermissionsDTO> {
    SysPermissionsDTO getByPermissionCode(String permissionCode);
    boolean deleteByPermissionCode(String permissionCode);
}
