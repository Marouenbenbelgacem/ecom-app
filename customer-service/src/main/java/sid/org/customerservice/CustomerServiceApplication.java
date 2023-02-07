package sid.org.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import sid.org.customerservice.entities.Customer;
import sid.org.customerservice.repo.CustomerRepository;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {

            customerRepository.saveAll(List.of(
                    Customer.builder().name("Mohamed").email("mohamed@gmail.com").build(),
                    Customer.builder().name("Ali").email("ALI@gmail.com").build(),
                    Customer.builder().name("Bachir").email("BACHRA@gmail.com").build(),
                    Customer.builder().name("Iman").email("IMAN@gmail.com").build()

            ));
            customerRepository.findAll().forEach(System.out::println);

        };

    }
}
