package com.example.exchangestudent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.exchangestudent.mapper")
public class ExchangeStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeStudentApplication.class, args);
	}

}
