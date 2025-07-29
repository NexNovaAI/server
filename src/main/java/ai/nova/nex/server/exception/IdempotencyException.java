package ai.nova.nex.server.exception;

/**
 * 幂等性异常
 *
 * @author xiaozhengrs
 * @date 2024/05/26
 */
public class IdempotencyException extends RuntimeException {
    public IdempotencyException(String message) {
        super(message);
    }
}
