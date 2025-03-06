package com.techie.microservies.inventory;

import org.springframework.boot.SpringApplication;

import com.techie.microservices.inventory.InventoryServiceApplication;

public class TestInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(InventoryServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
