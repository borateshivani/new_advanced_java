package com.demo.MyProductMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class MyProductMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProductMicroserviceApplication.class, args);
	}

}
