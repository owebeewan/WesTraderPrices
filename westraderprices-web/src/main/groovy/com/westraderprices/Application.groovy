package com.westraderprices

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
class Application {

    static void main(String[] args) {
        SpringApplication.run Application, args
		
		// command line loop forever
    }
}
