package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressbookAppApplication {

	public static void main(String[] args) {
        System.out.println("Welcome to Addressbook App Application");
		ApplicationContext context = SpringApplication.run(AddressbookAppApplication.class, args);
		log.info("Addressbook App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
	}
}
