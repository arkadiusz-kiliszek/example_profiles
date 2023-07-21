package com.example.example_profiles.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(1)
@Component
@Profile("!prod")
public class LocalCommand implements CommandLineRunner {

    @Value("${example.command.overwritten}")
    private String overwritten;

    @Value("${example.command.extented}")
    private String extended;

    @Override
    public void run(String... args) throws Exception {
        log.info("LocalCommand {} {}", overwritten, extended);
    }
}
