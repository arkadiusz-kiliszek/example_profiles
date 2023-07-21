package com.example.example_profiles.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Order(2)
@Component
public class DefaultCommand implements CommandLineRunner {

    @Value("${example.command.overwritten}")
    private String overwritten;

    @Value("${example.command.extented}")
    private String extended;

    //Dodatkowe mozliwosci @VALUE
    @Value("#{'${spring.profiles.active:unkown}'.split(',')}")
    private List<String> activeProfile;

    @Override
    public void run(String... args) throws Exception {
        log.info("DefaultCommand {} {} {}", overwritten, extended, activeProfile);
    }
}
