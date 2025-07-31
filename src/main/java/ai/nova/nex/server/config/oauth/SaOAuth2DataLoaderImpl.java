package ai.nova.nex.server.config.oauth;

import cn.dev33.satoken.oauth2.data.loader.SaOAuth2DataLoader;
import cn.dev33.satoken.oauth2.data.model.loader.SaClientModel;
import org.springframework.stereotype.Component;

/**
 * @author 小正
 * @date 2025年07月31日 16:14
 * @Description
 */
@Component
public class SaOAuth2DataLoaderImpl implements SaOAuth2DataLoader {
    // 根据 clientId 获取 Client 信息
    @Override
    public SaClientModel getClientModel(String clientId) {
        if("1001".equals(clientId)) {
            return new SaClientModel()
                    .addAllowRedirectUris("*");    // 所有允许授权的 url
        }
        return null;
    }
}
