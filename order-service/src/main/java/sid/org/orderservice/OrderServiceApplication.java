package sid.org.orderservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import sid.org.orderservice.entities.Order;
import sid.org.orderservice.entities.ProductItem;
import sid.org.orderservice.model.Customer;
import sid.org.orderservice.model.Product;
import sid.org.orderservice.repositories.OrderRepository;
import sid.org.orderservice.repositories.ProductItemRepository;
import sid.org.orderservice.services.CustomerRestClientService;
import sid.org.orderservice.services.InventoryRestClientService;
import sid.org.orderservice.status.OrderStatus;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (OrderRepository orderRepository,
                             ProductItemRepository productItemRepository,
                             CustomerRestClientService customerRestClientService,
                             InventoryRestClientService inventoryRestClientService) {
        return args -> {

            //recuperer la list des customers apres un appel versle MS customer-service
            List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().collect(Collectors.toList());
            //recuperer la list des produits apres un appel versle MS inventory-service
            List<Product> products = inventoryRestClientService.allProducts().getContent().stream().collect(Collectors.toList());

            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                // créer des order aleatoire
                Order order = Order.builder()
                        .customerId(customers.get(random.nextInt(customers.size())).getId())
                        .status(Math.random() > 0.5 ? OrderStatus.PENDING : OrderStatus.CREATED)
                        .createdDate(new Date())
                        .build();
                Order savedOrder = orderRepository.save(order);

                for (int j = 0; j < products.size(); j++) {
                    if (Math.random() > 0.70) {
                        ProductItem productItem = ProductItem.builder()
                                .order(savedOrder)
                                .discount(Math.random())
                                .price(products.get(j).getPrice())
                                .quantity(1 + random.nextInt(10))
                                .productId(products.get(j).getId())
                                .build();
                        productItemRepository.save(productItem);
                    }
                }

            }
        };

    }
}
