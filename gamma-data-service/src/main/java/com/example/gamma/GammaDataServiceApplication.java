package com.example.gamma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GammaDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GammaDataServiceApplication.class, args);
	}

}
