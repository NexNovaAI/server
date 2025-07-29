package ai.nova.nex.server.config.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 小正
 * @date 2024年12月18日 14:03
 * @Description 返回体封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private T data;
    private Integer code;
    private String message;

    public static <T> Result<T> succeed(String msg) {
        return of(null, 200, msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return of(model, 200, msg);
    }

    public static <T> Result<T> succeed(T model) {
        return of(model, 200, "");
    }

    public static <T> Result<T> of(T datas, Integer code, String msg) {
        return new Result<>(datas, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return of(null, -1, msg);
    }

    public static <T> Result<T> failed(T model, String msg) {
        return of(model, -1, msg);
    }
}
