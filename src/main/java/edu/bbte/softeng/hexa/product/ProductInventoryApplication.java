package edu.bbte.softeng.hexa.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "edu.bbte.softeng.hexa.product")
@EntityScan(basePackages = "edu.bbte.softeng.hexa.product.application.domain.entity")
public class ProductInventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductInventoryApplication.class, args);
    }
}
