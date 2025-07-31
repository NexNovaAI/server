package ai.nova.nex.server.service.db;

import ai.nova.nex.server.config.base.SuperService;
import ai.nova.nex.server.dto.SysUserDTO;

/**
 * @author 小正
 * @date 2025年07月29日 19:50
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SysUserService extends SuperService<SysUserDTO> {
    SysUserDTO getUserByUsername(String username);
}
