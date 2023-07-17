package com.nickprincy.vegassoccer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
		//(scanBasePackages= {"com.delivery.service","com.delivery.request"})
public class VegasSoccerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VegasSoccerApplication.class, args);
	}

}
