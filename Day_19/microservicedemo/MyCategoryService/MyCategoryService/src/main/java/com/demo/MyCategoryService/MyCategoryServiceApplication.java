package com.demo.MyCategoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MyCategoryServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyCategoryServiceApplication.class, args);
	}


	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RestClient restClient() {
         //RestClient.builder().baseUrl("http://localhost:9494");
		return RestClient.create();
	}

}
