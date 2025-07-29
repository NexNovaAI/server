package ai.nova.nex.server.config;

import cn.dev33.satoken.spring.SaBeanInject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.LazyInitializationExcludeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小正
 * @date 2025年02月28日 13:46
 * @Description 请填写此类描述
 */
@Configuration
@Slf4j
public class SATokenConfig {
    @Bean
    LazyInitializationExcludeFilter integrationLazyInitExcludeFilter() {
        log.info("SATokenConfig 装载");
        return LazyInitializationExcludeFilter.forBeanTypes(SaBeanInject.class);
    }
}
