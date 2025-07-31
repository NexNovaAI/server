package ai.nova.nex.server.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 小正
 * @date 2025年07月31日 17:14
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {
    NORMAL(1, "正常"),
    LOCKED(2, "锁定"),
    BAN(3, "封禁"),
    ;
    @EnumValue
    private final Integer code;
    private final String message;
    public static String getMessage(Integer code) {
        for (UserStatusEnum value : UserStatusEnum.values()) {
            if (value.code.equals(code)) {
                return value.message;
            }
        }
        return null;
    }
    public static Integer getCode(String message) {
        for (UserStatusEnum value : UserStatusEnum.values()) {
            if (value.message.equals(message)) {
                return value.code;
            }
        }
        return null;
    }
}
