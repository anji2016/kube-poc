package com.example.gamma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gamma.client.AlphaClient;
import com.example.gamma.client.BetaClient;

@RestController
@RequestMapping("/gamma")
public class GammaController {
	@Autowired
    private AlphaClient alphaDataServiceClient;
	
	@Autowired
    private BetaClient betaDataServiceClient;
    
	@GetMapping("/hello")
    public String hello() {
        String alphaDataServiceResponse = alphaDataServiceClient.hello();
        String betaDataServiceResponse = betaDataServiceClient.hello();
		return String.format("GammaDataService received: %s and %s", alphaDataServiceResponse, betaDataServiceResponse);
    }
}
