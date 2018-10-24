package com.atguigu.gmall.manger;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubbo
@SpringBootApplication
public class GmallMangerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallMangerWebApplication.class, args);
	}
}
