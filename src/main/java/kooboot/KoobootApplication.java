package kooboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component(value = "kooboot")
public class KoobootApplication {

    private static final String DEFAULT_CONFIG = new StringBuffer()
                .append("spring.config.location=")
                .append("classpath:application.yml")
                .toString();

    public static void main(String[] args) {
        String configuration = new StringBuffer(DEFAULT_CONFIG)
                .append(",")
                .append(System.getenv().get("CONFIG_PATH"))
                .append("real-application.yml")
                .toString();

        new SpringApplicationBuilder(KoobootApplication.class)
                .properties(configuration)
                .run(args);
    }
}
