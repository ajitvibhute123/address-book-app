package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookApplApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Application Program");
//		SpringApplication.run(AddressBookAppApplication.class, args);
		ApplicationContext context = SpringApplication.run(AddressBookApplApplication.class, args);
		log.info("AddressBook App Started in {} Environment",context.getEnvironment().getProperty("environment"));
		log.info("AddressBook App started");

	}

}