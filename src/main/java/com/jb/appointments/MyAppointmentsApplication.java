package com.jb.appointments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
public class MyAppointmentsApplication {

	public static void main(String[] args) {
		System.out.println("from master");
		SpringApplication.run(MyAppointmentsApplication.class, args);
	}

}
