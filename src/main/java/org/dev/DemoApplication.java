package org.dev;


import org.dev.dao.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	public ContactRepository contactRepository ;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	
}
