package com.sample.podidentity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OldSecretsManagerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OldSecretsManagerApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(OldSecretsManagerApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(@Value("${sample.key}") String key,@Value("${sample.value}") String value) {
        return args -> {
            LOGGER.info("`sample.key` loaded from the AWS Secret Manager: {}", key);
            LOGGER.info("`sample.value` loaded from the AWS Secret Manager: {}", value);
        };
    }
}
