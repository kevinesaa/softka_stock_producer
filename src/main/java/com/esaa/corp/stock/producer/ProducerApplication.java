package com.esaa.corp.stock.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ProducerApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}
