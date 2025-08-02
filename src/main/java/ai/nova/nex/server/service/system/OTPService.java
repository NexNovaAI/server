package ai.nova.nex.server.service.system;

import ai.nova.nex.server.utils.TOTP;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @author 小正
 * @date 2025年08月01日 21:00
 * @Description 请填写此类描述
 */
@Service
public class OTPService {
    // 生成随机密钥
    public String generateSecretKey() {
        byte[] buffer = new byte[10];
        new java.security.SecureRandom().nextBytes(buffer);
        return new Base32().encodeToString(buffer);
    }

    // 生成TOTP码
    public String getTOTPCode(String secretKey) {
        String normalizedBase32Key = secretKey.replace(" ", "").toUpperCase();
        Base32 base32 = new Base32();
        byte[] bytes = base32.decode(normalizedBase32Key);
        String hexKey = Hex.encodeHexString(bytes);
        long time = (new Date().getTime() / 1000) / 30;
        String hexTime = Long.toHexString(time);
        return TOTP.generateTOTP(hexKey, hexTime, "6", "HmacSHA1");
    }

    // 验证TOTP码
    public boolean verifyCode(String secretKey, String code) {
        String generatedCode = getTOTPCode(secretKey);
        return generatedCode.equals(code);
    }

    // 生成Google Authenticator二维码内容
    public String getGoogleAuthenticatorBarCode(String secretKey, String account, String issuer) {
        return String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s",
                issuer, account, secretKey, issuer);
    }
}
