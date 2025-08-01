package ai.nova.nex.server.service.db;

import ai.nova.nex.server.config.base.SuperService;
import ai.nova.nex.server.dto.SysUserRoleDTO;

/**
 * @author 小正
 * @date 2025年08月01日 11:12
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SysUserRoleService extends SuperService<SysUserRoleDTO> {
    SysUserRoleDTO getByUserId(Long userId);
    boolean deleteByUserId(Long userId);
}
