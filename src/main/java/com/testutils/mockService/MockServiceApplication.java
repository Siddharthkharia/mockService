package com.testutils.mockService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockServiceApplication.class, args);
	}

}
