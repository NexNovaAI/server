package ai.nova.nex.server.exception;



import ai.nova.nex.server.config.base.Result;
import cn.dev33.satoken.exception.SaTokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

/**
 * @author 小正
 * @date 2025年01月15日 14:54
 * @Description 请填写此类描述
 */
@ResponseBody
@Slf4j
public class DefaultExceptionAdvice {
    /**
     * IllegalArgumentException异常处理返回json
     * 返回状态码:400
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public Result badRequestException(IllegalArgumentException e) {
        return defHandler("参数解析失败", e);
    }

    /**
     * AccessDeniedException异常处理返回json
     * 返回状态码:403
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({AccessDeniedException.class})
    public Result badMethodExpressException(AccessDeniedException e) {
        return defHandler("没有权限请求当前方法", e);
    }


    /**
     * 返回状态码:405
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return defHandler("不支持当前请求方法", e);
    }

    /**
     * 返回状态码:415
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        return defHandler("不支持当前媒体类型", e);
    }

    /**
     * SQLException sql异常处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({SQLException.class})
    public Result handleSQLException(SQLException e) {
        return defHandler("SQLException异常", e);
    }

    /**
     * BusinessException 业务异常处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public Result handleException(BusinessException e) {
        return defHandler("业务异常", e);
    }

    /**
     * IdempotencyException 幂等性异常
     * 返回状态码:200
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(IdempotencyException.class)
    public Result handleException(IdempotencyException e) {
        return Result.failed(e.getMessage());
    }

    /**
     * 所有异常统一处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return defHandler("未知异常", e);
    }


    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(SaTokenException.class)
    public Result handleException(SaTokenException e) {
        return defHandler(e.getMessage(), e);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoResourceFoundException.class)
    public Result handleException(NoResourceFoundException e) {
        return defHandler(e.getMessage(), e);
    }

    /**
     * 所有异常统一处理
     * 返回状态码:500
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handleException(NoHandlerFoundException e) {
        return defHandler("无此接口", e);
    }

    private Result defHandler(String msg, Exception e) {
        log.error(msg, e);
        return Result.failed(msg);
    }
}
