package de.bnd.coding.sample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: Password still saved in cleartext
//TODO: Recommondation Zip-code based: Multiple Zip code for an area! Think of something.

@SpringBootApplication
public class Co2demoApplication {

	public static void main(String[] args) {

		SpringApplication.run(Co2demoApplication.class, args);
	}

}
