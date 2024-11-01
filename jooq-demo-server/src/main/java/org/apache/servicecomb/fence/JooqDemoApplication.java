package org.apache.servicecomb.fence;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JooqDemoApplication {
    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(JooqDemoApplication.class).web(WebApplicationType.NONE).run(args);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}