package com.woollen.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.woollen.order.mapper")
public class OrderControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderControllerApplication.class, args);
	}

}
