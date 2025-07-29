package ai.nova.nex.server.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小正
 * @date 2025年07月29日 19:31
 * @Description 请填写此类描述
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "system")
public class SystemProperties {
    public String aesSecret;
}
