package com.oes.orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.oes.http.OesClient;
import com.oes.model.Product;


@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "com.oes")
@EnableJpaRepositories("com.oes.repository")
@EntityScan("com.oes.model")
public class OrdersApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loaded application successfully");
		
		OesClient c = new OesClient();
		
		Product p = c.getProductById("8ed0e6f7");
		System.out.println("Prduct ID" + p.getId());
	}

}
