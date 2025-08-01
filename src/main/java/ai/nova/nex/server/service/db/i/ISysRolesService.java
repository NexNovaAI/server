package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysRolesDTO;
import ai.nova.nex.server.mapper.SysRolesMapper;
import ai.nova.nex.server.service.db.SysRolesService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 小正
 * @date 2025年08月01日 11:14
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysRolesService extends SuperServiceImpl<SysRolesMapper, SysRolesDTO> implements SysRolesService {
    @Override
    public SysRolesDTO getByRoleCode(String roleCode) {
        LambdaQueryWrapper<SysRolesDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRolesDTO::getRoleCode, roleCode);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean deleteByRoleCode(String roleCode) {
        LambdaQueryWrapper<SysRolesDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRolesDTO::getRoleCode, roleCode);
        return baseMapper.delete(queryWrapper) > 0;
    }
}
