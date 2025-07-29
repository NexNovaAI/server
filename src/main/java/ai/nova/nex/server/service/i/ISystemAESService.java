package ai.nova.nex.server.service.i;

import ai.nova.nex.server.config.properties.SystemProperties;
import ai.nova.nex.server.service.SystemAESService;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.extra.spring.SpringUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * @author 小正
 * @date 2025年07月29日 19:33
 * @Description 请填写此类描述
 */
@Service
@Slf4j
public class ISystemAESService implements SystemAESService {

    private SystemProperties SystemProperties;
    private String AesSecret;
    private SymmetricCrypto Aes;

    public ISystemAESService() {
        this.SystemProperties = SpringUtil.getBean(SystemProperties.class);
        log.info("初始化AES");
        if (ObjectUtil.isNull(this.SystemProperties.getAesSecret())) {
            log.info("AES密钥不存在，系统将随机生成一个AES密钥");
            this.AesSecret = Base64.getEncoder().encodeToString(SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded());
        }else {
            this.AesSecret = this.SystemProperties.getAesSecret();
        }
        log.info("AES密钥：{} , 开始构建编解码器.", this.AesSecret);
        this.Aes = new SymmetricCrypto(SymmetricAlgorithm.AES, Base64.getDecoder().decode(this.AesSecret));
        log.info("AES编解码器构建成功.");
    }

    @Override
    public String aesEncrypt(String content) {
        return this.Aes.encryptBase64(content);
    }


    @Override
    public String aesDecrypt(String content) {
        return this.Aes.decryptStr(content);
    }

    @Override
    public SymmetricCrypto getAES() {
        return this.Aes;
    }
}
