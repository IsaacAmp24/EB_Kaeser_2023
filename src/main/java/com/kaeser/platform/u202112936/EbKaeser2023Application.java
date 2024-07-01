package com.kaeser.platform.u202112936;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EbKaeser2023Application {

    public static void main(String[] args) {
        SpringApplication.run(EbKaeser2023Application.class, args);
    }

}
