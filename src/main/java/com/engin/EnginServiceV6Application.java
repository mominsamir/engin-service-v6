package com.engin;

import com.engin.controller.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.engin" })
public class EnginServiceV6Application {
	public static void main(String[] args) {
		SpringApplication.run(EnginServiceV6Application.class, args);
	}

}
