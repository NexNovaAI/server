package ai.nova.nex.server.service.db;

import ai.nova.nex.server.config.base.SuperService;
import ai.nova.nex.server.dto.SysRolePermissionDTO;

import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 11:11
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SysRolePermissionService extends SuperService<SysRolePermissionDTO> {
    SysRolePermissionDTO getByRoleCode(String roleCode);
    List<String> getPermissionCodes(List<String> roleCodes);
    boolean deleteByRoleCode(String roleCode);
}
