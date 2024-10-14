package com.example.Redis_Integration;

import com.example.Redis_Integration.Entities.Product;
import com.example.Redis_Integration.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class RedisIntegrationApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(RedisIntegrationApplication.class, args);
	}
             

	@Override
	public void run(String... args) throws Exception {
		Product product = Product.builder()
				.id(UUID.randomUUID().toString())
				.name("Keyboard")
				.price("500$")
				.build();
		this.productService.addProduct(product);
		System.out.println("Product added");

		System.out.println(this.productService.getProduct(product.getId()));

		System.out.println(this.productService.deleteProduct(product.getId()));
		System.out.println("Product Deleted.....");
	}
}
