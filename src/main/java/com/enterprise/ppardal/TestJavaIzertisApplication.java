package com.enterprise.ppardal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TestJavaIzertisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJavaIzertisApplication.class, args);
	}

}
