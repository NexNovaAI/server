package ai.nova.nex.server.config;




import ai.nova.nex.server.exception.DefaultExceptionAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author 小正
 * @date 2024年05月31日 11:41
 * @Description 全局异常处理
 * @ControllerAdvice 表示该类是一个控制器增强类，用于处理控制器抛出的异常。
 */
@ControllerAdvice
public class ExceptionAdvice extends DefaultExceptionAdvice {
}
