package ai.nova.nex.server.config.oauth.grant.type;

import ai.nova.nex.server.dto.SysUserDTO;
import ai.nova.nex.server.service.business.AccountService;
import ai.nova.nex.server.service.db.SysUserService;
import cn.dev33.satoken.oauth2.exception.SaOAuth2Exception;
import cn.dev33.satoken.oauth2.granttype.handler.PasswordGrantTypeHandler;
import cn.dev33.satoken.oauth2.granttype.handler.model.PasswordAuthResult;
import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author 小正
 * @date 2025年07月31日 15:37
 * @Description 自定义 Password Grant_Type 授权模式处理器认证过程
 */
@Component
public class CustomPasswordGrantTypeHandler extends PasswordGrantTypeHandler {


    @Resource
    private AccountService AccountService;
    @Resource
    private SysUserService SysUserService;

    @Override
    public PasswordAuthResult loginByUsernamePassword(String username, String password) {
        SysUserDTO user = SysUserService.getUserByUsername(username);
        if (ObjectUtil.isNull(user)){
            throw new SaOAuth2Exception("此账号不存在");
        }
        if (AccountService.login(user, password)){
            return new PasswordAuthResult(user.getId());
        }
        throw new SaOAuth2Exception("密码错误");
    }
}
