package com.example.tp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tp2Application {

	public static void main(String[] args) {
		System.getProperties().put( "server.port", 9000 );  // port is set here
		SpringApplication.run(Tp2Application.class, args);
	}

}
