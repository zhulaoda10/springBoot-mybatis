package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.neo.mapper")
@EnableCaching
public class MybatisXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisXmlApplication.class, args);
	}
}
