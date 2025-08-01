package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysTemporaryPermissionsDTO;
import ai.nova.nex.server.mapper.SysTemporaryPermissionsMapper;
import ai.nova.nex.server.service.db.SysTemporaryPermissionsService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 11:14
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysTemporaryPermissionsService extends SuperServiceImpl<SysTemporaryPermissionsMapper, SysTemporaryPermissionsDTO> implements SysTemporaryPermissionsService {
    @Override
    public List<SysTemporaryPermissionsDTO> getByUserId(Long userId,boolean isUsable) {
        LambdaQueryWrapper<SysTemporaryPermissionsDTO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysTemporaryPermissionsDTO::getUid, userId);
        if (isUsable){
            // 获取当前时间
            Date currentDate = DateUtil.date();
            queryWrapper.le(SysTemporaryPermissionsDTO::getStartAt, currentDate)  // 生效时间 <= 当前时间
                    .ge(SysTemporaryPermissionsDTO::getExpiresAt, currentDate);   // 到期时间 >= 当前时间
        }
        return baseMapper.selectList(queryWrapper);
    }
}
