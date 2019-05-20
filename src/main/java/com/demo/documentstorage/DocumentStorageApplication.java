package com.demo.documentstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DocumentStorageApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DocumentStorageApplication.class, args);
	}

}
