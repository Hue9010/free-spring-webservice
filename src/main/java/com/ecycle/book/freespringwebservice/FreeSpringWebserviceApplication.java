package com.ecycle.book.freespringwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FreeSpringWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeSpringWebserviceApplication.class, args);
	}

}
