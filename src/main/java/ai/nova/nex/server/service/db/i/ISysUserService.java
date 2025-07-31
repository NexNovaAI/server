package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysUserDTO;
import ai.nova.nex.server.mapper.SysUserMapper;
import ai.nova.nex.server.service.db.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 小正
 * @date 2025年07月29日 19:51
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysUserService extends SuperServiceImpl<SysUserMapper, SysUserDTO> implements SysUserService {
    @Override
    public SysUserDTO getUserByUsername(String username) {
        LambdaQueryWrapper<SysUserDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserDTO::getUsername, username);
        return baseMapper.selectOne(queryWrapper);
    }
}
