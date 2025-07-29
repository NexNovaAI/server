package ai.nova.nex.server.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 小正
 * @date 2025年03月04日 16:07
 * @Description 请填写此类描述
 */
@Configuration
@Slf4j
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册 Sa-Token 拦截器，打开注解式鉴权功能
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("SaTokenConfigure addInterceptors 装载");
        // 注册 Sa-Token 拦截器，定义详细认证规则
        registry.addInterceptor(new SaInterceptor(handler -> {
            SaRouter.match("/**").check(r -> {
                // 打印请求路径请求头请求参数
                log.info("请求路径: {}, 请求方式: {}, 请求参数: {}", SaHolder.getRequest().getRequestPath(), SaHolder.getRequest().getMethod(), SaHolder.getRequest().getParamMap());
            });
            // 指定一条 match 规则
            SaRouter.match("/**").check(r -> StpUtil.checkLogin());
        })).addPathPatterns("/**");
    }
}
