package ai.nova.nex.server.service.db;

import ai.nova.nex.server.config.base.SuperService;
import ai.nova.nex.server.dto.SysOauthClientDTO;
import ai.nova.nex.server.mapper.SysOauthClientMapper;

/**
 * @author 小正
 * @date 2025年07月31日 16:50
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SysOauthClientService extends SuperService<SysOauthClientDTO> {
    SysOauthClientDTO getClientByClientId(String clientId);
}
