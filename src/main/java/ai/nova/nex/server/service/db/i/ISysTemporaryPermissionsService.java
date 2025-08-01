package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysTemporaryPermissionsDTO;
import ai.nova.nex.server.mapper.SysTemporaryPermissionsMapper;
import ai.nova.nex.server.service.db.SysTemporaryPermissionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 小正
 * @date 2025年08月01日 11:14
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysTemporaryPermissionsService extends SuperServiceImpl<SysTemporaryPermissionsMapper, SysTemporaryPermissionsDTO> implements SysTemporaryPermissionsService {
}
