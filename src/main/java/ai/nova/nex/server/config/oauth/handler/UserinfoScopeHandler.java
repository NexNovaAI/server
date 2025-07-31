package ai.nova.nex.server.config.oauth.handler;

import ai.nova.nex.server.dto.SysOauthClientDTO;
import ai.nova.nex.server.dto.SysUserDTO;
import ai.nova.nex.server.service.db.SysOauthClientService;
import ai.nova.nex.server.service.db.SysUserService;
import cn.dev33.satoken.oauth2.data.model.AccessTokenModel;
import cn.dev33.satoken.oauth2.data.model.ClientTokenModel;
import cn.dev33.satoken.oauth2.scope.handler.SaOAuth2ScopeHandlerInterface;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 小正
 * @date 2025年07月31日 15:58
 * @Description 自定义 userinfo scope 处理器
 */
@Component
@Slf4j
public class UserinfoScopeHandler implements SaOAuth2ScopeHandlerInterface {


    @Resource
    private SysOauthClientService SysOAuthClientService;
    @Resource
    private SysUserService SysUserService;

    // 指示当前处理器所要处理的 scope
    @Override
    public String getHandlerScope() {
        return "userinfo";
    }

    // 当构建的 AccessToken 具有此权限时，所需要执行的方法
    @Override
    public void workAccessToken(AccessTokenModel at) {
        log.info("--------- userinfo 权限，加工 AccessTokenModel --------- ");
        SysOauthClientDTO client = SysOAuthClientService.getClientByClientId(at.clientId);
        SysUserDTO user = SysUserService.getById(client.getUid());
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("username", user.getUsername());
        map.put("phone", user.getPhone());
        map.put("mailbox", user.getMailbox());
        map.put("user_status", user.getUserStatus());
        at.extraData.putAll(map);
    }

    // 当构建的 ClientToken 具有此权限时，所需要执行的方法
    @Override
    public void workClientToken(ClientTokenModel ct) {
    }

    // 当使用 RefreshToken 刷新 AccessToken 时，是否重新执行 workAccessToken 构建方法
    // 在一些实时性较高的数据中需要指定为 true
    @Override
    public boolean refreshAccessTokenIsWork() {
        return true;
    }
}
