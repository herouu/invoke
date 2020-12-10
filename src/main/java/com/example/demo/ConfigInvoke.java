package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigInvoke {

    @Bean
    public FileInvoke fileInvoke() {
        return new FileInvoke();
    }

}
