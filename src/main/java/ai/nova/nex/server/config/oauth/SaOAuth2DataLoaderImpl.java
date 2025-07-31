package ai.nova.nex.server.config.oauth;

import ai.nova.nex.server.dto.SysOauthClientDTO;
import ai.nova.nex.server.service.db.SysOauthClientService;
import cn.dev33.satoken.oauth2.data.loader.SaOAuth2DataLoader;
import cn.dev33.satoken.oauth2.data.model.loader.SaClientModel;
import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author 小正
 * @date 2025年07月31日 16:14
 * @Description
 */
@Component
public class SaOAuth2DataLoaderImpl implements SaOAuth2DataLoader {


    @Resource
    private SysOauthClientService SysOauthClientService;


    // 根据 clientId 获取 Client 信息
    @Override
    public SaClientModel getClientModel(String clientId) {
        SysOauthClientDTO sysOauthClientDTO = SysOauthClientService.getClientByClientId(clientId);
        if (ObjectUtil.isNull(sysOauthClientDTO)){
            return null;
        }
        return new SaClientModel()
                .addAllowRedirectUris(sysOauthClientDTO.getRedirectUri())
                .setClientSecret(sysOauthClientDTO.getClientSecret())
                .setAllowGrantTypes(sysOauthClientDTO.getGrantTypes())
                .setContractScopes(sysOauthClientDTO.getScope());
    }
}
