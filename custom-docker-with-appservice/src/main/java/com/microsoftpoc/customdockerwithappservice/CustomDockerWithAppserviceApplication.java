package com.microsoftpoc.customdockerwithappservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CustomDockerWithAppserviceApplication {

	@GetMapping("/")
	public String welcome(){
		return "welcome to custom docker with app service application";
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomDockerWithAppserviceApplication.class, args);
	}

}
