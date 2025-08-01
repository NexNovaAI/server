package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysUserRoleDTO;
import ai.nova.nex.server.mapper.SysUserRoleMapper;
import ai.nova.nex.server.service.db.SysUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 小正
 * @date 2025年08月01日 11:14
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysUserRoleService extends SuperServiceImpl<SysUserRoleMapper, SysUserRoleDTO> implements SysUserRoleService {
}
