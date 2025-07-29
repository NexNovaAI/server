package ai.nova.nex.server;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;

@Slf4j
@SpringBootTest
class ServerApplicationTests {



    /*
    * 生成系统密钥用于对铭感数据进行加密解密
    * */
    @Test
    void generateKey() {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        String base64Key = Base64.getEncoder().encodeToString(key);
        log.info("base64Key: {}", base64Key);
    }

    @Test
    void contextLoads() {
    }

}
