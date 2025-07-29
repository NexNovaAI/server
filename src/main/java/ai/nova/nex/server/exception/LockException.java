package ai.nova.nex.server.exception;

/**
 * 分布式锁异常
 *
 * @author xiaozhengrs
 * @date 2024/05/26
 */
public class LockException extends RuntimeException {

    public LockException(String message) {
        super(message);
    }
}
