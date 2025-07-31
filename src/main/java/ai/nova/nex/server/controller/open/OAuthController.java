package ai.nova.nex.server.controller.open;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.oauth2.processor.SaOAuth2ServerProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小正
 * @date 2025年07月31日 15:10
 * @Description 请填写此类描述
 */
@RequestMapping("/open/oauth")
@RestController
@Slf4j
public class OAuthController {
    // 模式一：Code授权码 || 模式二：隐藏式
    @RequestMapping("/authorize")
    public Object authorize() {
        return SaOAuth2ServerProcessor.instance.authorize();
    }

    // 用户登录
    @RequestMapping("/doLogin")
    public Object doLogin() {
        return SaOAuth2ServerProcessor.instance.doLogin();
    }

    // 用户确认授权
    @RequestMapping("/doConfirm")
    public Object doConfirm() {
        return SaOAuth2ServerProcessor.instance.doConfirm();
    }

    // Code 换 Access-Token || 模式三：密码式
    @RequestMapping("/token")
    public Object token() {
        return SaOAuth2ServerProcessor.instance.token();
    }

    // Refresh-Token 刷新 Access-Token
    @RequestMapping("/refresh")
    public Object refresh() {
        return SaOAuth2ServerProcessor.instance.refresh();
    }

    // 回收 Access-Token
    @RequestMapping("/revoke")
    public Object revoke() {
        return SaOAuth2ServerProcessor.instance.revoke();
    }

    // 模式四：凭证式
    @RequestMapping("/client_token")
    public Object clientToken() {
        return SaOAuth2ServerProcessor.instance.clientToken();
    }
}
