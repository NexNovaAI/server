package ai.nova.nex.server.service;

import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * @author 小正
 * @date 2025年07月29日 19:33
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SystemAESService {
    String aesEncrypt(String content);
    String aesDecrypt(String content);
    SymmetricCrypto getAES();
}
