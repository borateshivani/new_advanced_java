package com.demo.MyAPIGateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class MyApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApiGateWayApplication.class, args);
	}

}
