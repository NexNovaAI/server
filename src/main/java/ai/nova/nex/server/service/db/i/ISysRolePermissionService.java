package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysRolePermissionDTO;
import ai.nova.nex.server.mapper.SysRolePermissionMapper;
import ai.nova.nex.server.service.db.SysRolePermissionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 11:14
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysRolePermissionService extends SuperServiceImpl<SysRolePermissionMapper, SysRolePermissionDTO> implements SysRolePermissionService {
    @Override
    public SysRolePermissionDTO getByRoleCode(String roleCode) {
        LambdaQueryWrapper<SysRolePermissionDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRolePermissionDTO::getRoleCode, roleCode);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<String> getPermissionCodes(List<String> roleCodes) {
        LambdaQueryWrapper<SysRolePermissionDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(SysRolePermissionDTO::getRoleCode, roleCodes);
        return baseMapper.selectList(queryWrapper).stream().map(SysRolePermissionDTO::getPermissionCodes).flatMap(List::stream).distinct().toList();
    }

    @Override
    public boolean deleteByRoleCode(String roleCode) {
        LambdaQueryWrapper<SysRolePermissionDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRolePermissionDTO::getRoleCode, roleCode);
        return baseMapper.delete(queryWrapper) > 0;
    }
}
