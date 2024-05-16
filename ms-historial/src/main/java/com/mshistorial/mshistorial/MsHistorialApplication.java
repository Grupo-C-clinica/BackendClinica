package com.mshistorial.mshistorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MsHistorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsHistorialApplication.class, args);
	}


}
