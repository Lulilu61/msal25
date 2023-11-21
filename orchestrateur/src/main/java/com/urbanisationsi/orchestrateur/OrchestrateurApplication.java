package com.urbanisationsi.orchestrateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.urbanisationsi.orchestrateur")
@EnableDiscoveryClient
public class OrchestrateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestrateurApplication.class, args);
	}

}
