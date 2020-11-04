package com.wsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.wsl.dao"})//这块必须的
public class SpringShiroDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShiroDemoApplication.class, args);
	}

}
