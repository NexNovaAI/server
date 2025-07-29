package ai.nova.nex.server.exception;

/**
 * 业务异常
 *
 * @author xiaozhengrs
 * @date 2024/05/26
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public BusinessException(String message) {
        super(message);
    }
}
