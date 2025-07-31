package ai.nova.nex.server.service.db.i;

import ai.nova.nex.server.config.base.impl.SuperServiceImpl;
import ai.nova.nex.server.dto.SysOauthClientDTO;
import ai.nova.nex.server.mapper.SysOauthClientMapper;
import ai.nova.nex.server.service.db.SysOauthClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 小正
 * @date 2025年07月31日 16:51
 * @Description 请填写此类描述
 */
@Slf4j
@Service
public class ISysOauthClientService extends SuperServiceImpl<SysOauthClientMapper, SysOauthClientDTO> implements SysOauthClientService {
    @Override
    public SysOauthClientDTO getClientByClientId(String clientId) {
        return getById(clientId);
    }
}
