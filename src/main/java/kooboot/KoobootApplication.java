package kooboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class KoobootApplication {

    public static final String CONFING_LOCATIONS = new StringBuffer()
            .append("spring.config.location=")
            .append("classpath:application.yml,")
            .append("/Users/song/song/blog/real-application.yml")
            .toString();

    public static void main(String[] args) {
        new SpringApplicationBuilder(KoobootApplication.class)
                .properties(CONFING_LOCATIONS)
                .run(args);
    }
}
