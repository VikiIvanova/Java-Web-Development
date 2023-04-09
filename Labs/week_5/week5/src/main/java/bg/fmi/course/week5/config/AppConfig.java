package bg.fmi.course.week5.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties(prefix= "config")
@Configuration
@Data
public class AppConfig {
    private  LoggerConfig logger = new LoggerConfig();
    private Dealership dealership = new Dealership();

    @Data
    public class LoggerConfig {
        private String level;
        private String name;
    }

    @Data
    public class Dealership {
        private Integer maxTaxRate;
        private Map<Integer, String> numbers;
    }
}
