package ai.nova.nex.server.config.oauth;

import cn.dev33.satoken.oauth2.config.SaOAuth2ServerConfig;
import cn.dev33.satoken.oauth2.strategy.SaOAuth2Strategy;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小正
 * @date 2025年07月31日 16:11
 * @Description OAuth2 配置
 */
@Configuration
public class OAuth2Config {
    @Autowired
    public void configOAuth2Server(SaOAuth2ServerConfig oauth2Server) {
        // 重写 AccessToken 创建策略，返回会话令牌
        SaOAuth2Strategy.instance.createAccessToken = (clientId, loginId, scopes) -> {
            return StpUtil.getOrCreateLoginSession(loginId);
        };

    }
}
