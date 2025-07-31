package ai.nova.nex.server;

import ai.nova.nex.server.entity.model.RegisterUserModel;
import ai.nova.nex.server.enums.UserStatusEnum;
import ai.nova.nex.server.service.business.AccountService;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@Slf4j
@SpringBootTest
class ServerApplicationTests {

    @Resource
    private AccountService accountService;


    /*
     * 生成系统密钥用于对铭感数据进行加密解密
     * */
    @Test
    void generateKey() {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(key);
        log.info("base64Key: {}", base64Key);
    }

    /*
     * 注册账号
     * */
    @Test
    void register() {
        RegisterUserModel registerUserModel = new RegisterUserModel();
        registerUserModel.setUsername("admin");
        registerUserModel.setPassword("123456");
        registerUserModel.setMailbox("admin@nova.ai");
        registerUserModel.setRegisterAddress("127.0.0.1");
        accountService.register(registerUserModel);
    }

    @Test
    void contextLoads() {
    }

}
