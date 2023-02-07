package sid.org.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import sid.org.inventoryservice.entities.Product;
import sid.org.inventoryservice.repo.ProductRepository;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductRepository productRepository) {

        return args -> {

        	Random random = new Random();
        for (int i = 1; i < 10; i++) {

        	productRepository.saveAll(List.of(
        				Product.builder()
        						.name("ecran"+i)
        					.price(1200+ Math.random()*10000)
        						.quantity(1+random.nextInt(200))
        					.build()
        		));
        	}

        	productRepository.findAll().forEach(System.out::println);
        	};
        /*return args -> {
            Random random = new Random();
            productRepository.saveAll(List.of(
                    Product.builder()
                            .name("ecran")
                            .price(1200 + Math.random() * 10000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder()
                            .name("laptop")
                            .price(1200 + Math.random() * 10000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder()
                            .name("souris")
                            .price(1200 + Math.random() * 10000)
                            .quantity(1 + random.nextInt(200)).build(),
                    Product.builder()
                            .name("clavier")
                            .price(1200 + Math.random() * 10000)
                            .quantity(1 + random.nextInt(200)).build()

            ));
            productRepository.findAll().forEach(System.out::println);
        };*/

    }

}
