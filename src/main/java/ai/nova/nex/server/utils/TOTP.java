package ai.nova.nex.server.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/**
 * @author 小正
 * @date 2025年08月01日 21:01
 * @Description 请填写此类描述
 */
public class TOTP {
    private TOTP() {}

    public static String generateTOTP(String key, String time, String returnDigits, String crypto) {
        return generateTOTP(key, time, returnDigits, crypto, 0);
    }

    public static String generateTOTP(String key, String time, String returnDigits,
                                      String crypto, long skew) {
        StringBuilder result = new StringBuilder();
        long newTime = Long.parseLong(time) + skew;
        time = Long.toHexString(newTime).toUpperCase();
        while (time.length() < 16) {
            time = "0" + time;
        }

        byte[] msg = hexStr2Bytes(time);
        byte[] k = hexStr2Bytes(key);
        byte[] hash = hmac_sha(crypto, k, msg);

        int offset = hash[hash.length - 1] & 0xf;
        int binary = ((hash[offset] & 0x7f) << 24) |
                ((hash[offset + 1] & 0xff) << 16) |
                ((hash[offset + 2] & 0xff) << 8) |
                (hash[offset + 3] & 0xff);

        int otp = binary % (int) Math.pow(10, Integer.parseInt(returnDigits));
        result.append(otp);
        while (result.length() < Integer.parseInt(returnDigits)) {
            result.insert(0, "0");
        }
        return result.toString();
    }

    private static byte[] hexStr2Bytes(String hex) {
        byte[] bArray = new BigInteger("10" + hex, 16).toByteArray();
        byte[] ret = new byte[bArray.length - 1];
        System.arraycopy(bArray, 1, ret, 0, ret.length);
        return ret;
    }

    private static byte[] hmac_sha(String crypto, byte[] keyBytes, byte[] text) {
        try {
            Mac hmac = Mac.getInstance(crypto);
            SecretKeySpec macKey = new SecretKeySpec(keyBytes, crypto);
            hmac.init(macKey);
            return hmac.doFinal(text);
        } catch (GeneralSecurityException gse) {
            throw new UndeclaredThrowableException(gse);
        }
    }
}
