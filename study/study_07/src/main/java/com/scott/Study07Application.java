package com.scott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableSwagger2
public class Study07Application {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(Study07Application.class, args);
	}

}
