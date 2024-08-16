package com.example.gamma.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="beta-data-service")
public interface BetaClient {
	@GetMapping("/beta/hello")
    String hello();
}
