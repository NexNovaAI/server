package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysPermissionsDTO;
import ai.nova.nex.server.mapper.SysPermissionsMapper;
import ai.nova.nex.server.service.db.SysPermissionsService;
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
public class ISysPermissionsService extends SuperServiceImpl<SysPermissionsMapper, SysPermissionsDTO> implements SysPermissionsService {
    @Override
    public SysPermissionsDTO getByPermissionCode(String permissionCode) {
        LambdaQueryWrapper<SysPermissionsDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysPermissionsDTO::getPermissionCode, permissionCode);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean deleteByPermissionCode(String permissionCode) {
        LambdaQueryWrapper<SysPermissionsDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysPermissionsDTO::getPermissionCode, permissionCode);
        return baseMapper.delete(queryWrapper) > 0;
    }
}
