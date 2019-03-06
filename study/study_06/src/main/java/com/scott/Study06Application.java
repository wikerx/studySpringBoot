package com.scott;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scott.mapper")
public class Study06Application {

	public static void main(String[] args) {
		SpringApplication.run(Study06Application.class, args);
	}

}
