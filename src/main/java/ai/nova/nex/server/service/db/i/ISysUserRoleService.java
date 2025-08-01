package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysUserRoleDTO;
import ai.nova.nex.server.mapper.SysUserRoleMapper;
import ai.nova.nex.server.service.db.SysUserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
    @Override
    public SysUserRoleDTO getByUserId(Long userId) {
        LambdaQueryWrapper<SysUserRoleDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRoleDTO::getUid, userId);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean deleteByUserId(Long userId) {
        LambdaQueryWrapper<SysUserRoleDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserRoleDTO::getUid, userId);
        return baseMapper.delete(queryWrapper) > 0;
    }
}
