package ai.nova.nex.server.service.business;

import ai.nova.nex.server.entity.model.RegisterUserModel;

/**
 * @author 小正
 * @date 2025年07月29日 19:59
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 账户服务
 */
public interface AccountService {
    boolean register(RegisterUserModel registerUserModel);
}
