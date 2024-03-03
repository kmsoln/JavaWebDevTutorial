package com.labs.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThymeleafApplication {

    private static final Logger logger = LoggerFactory.getLogger(ThymeleafApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ThymeleafApplication.class);
        ConfigurableApplicationContext context = app.run(args);

        logServerInfo(context);
    }

    private static void logServerInfo(ConfigurableApplicationContext context) {
        String port = context.getEnvironment().getProperty("server.port");
        String contextPath = context.getEnvironment().getProperty("server.servlet.context-path");

        log("Server running at: http://localhost:" + port + contextPath);
    }

    private static void log(String message){
        logger.info(message);
    }
}