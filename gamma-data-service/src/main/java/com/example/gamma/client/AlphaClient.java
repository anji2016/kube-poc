package com.example.gamma.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="alpha-data-service")
public interface AlphaClient {
	@GetMapping("/alpha/hello")
    String hello();
}
