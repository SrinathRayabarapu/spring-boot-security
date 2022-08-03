package com.practice.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@SpringBootApplication
public class SpringBootSecurityApplication {

	public static BlockingQueue BLOCKING_QUEUE = new ArrayBlockingQueue(1);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

}