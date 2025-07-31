package ai.nova.nex.server.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 小正
 * @date 2025年07月31日 17:10
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
@Getter
@AllArgsConstructor
public enum OTPStatusEnum {
    NOT_ENABLED(0, "未启用"),
    ON_ENABLED(1, "已启用"),
    ;
    @EnumValue
    private final Integer code;
    private final String message;

    public static String getMessage(Integer code) {
        for (OTPStatusEnum value : OTPStatusEnum.values()) {
            if (value.getCode().equals(code)) {
                return value.getMessage();
            }
        }
        return null;
    }

    public static Integer getCode(String message) {
        for (OTPStatusEnum value : OTPStatusEnum.values()) {
            if (value.getMessage().equals(message)) {
                return value.getCode();
            }
        }
        return null;
    }
}
