package com.urbanisationsi.microservices_contrat_mongoDB_correction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MicroservicesContratMongoDbCorrectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesContratMongoDbCorrectionApplication.class, args);
	}

}
