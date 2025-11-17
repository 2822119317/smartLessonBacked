package com.neu.smartLesson.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {
    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure()
                .directory("./") // 指向根目录
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }
}