package com.manoj.practice.SampleSpringBoot.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.manoj")
public class Application extends SpringBootServletInitializer {

    private static final Log LOG = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        LOG.info("Initializing the Sample Spring Boot application....");
        new SpringApplicationBuilder().sources(Application.class).run(args);
    }

}
