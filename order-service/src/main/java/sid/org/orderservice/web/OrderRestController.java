package sid.org.orderservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sid.org.orderservice.entities.Order;
import sid.org.orderservice.model.Customer;
import sid.org.orderservice.model.Product;
import sid.org.orderservice.repositories.OrderRepository;
import sid.org.orderservice.repositories.ProductItemRepository;
import sid.org.orderservice.services.CustomerRestClientService;
import sid.org.orderservice.services.InventoryRestClientService;

import java.util.Optional;

@RestController
public class OrderRestController {


    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @Autowired
    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/fullOrder/{id}")
    public Optional<Order> getOrder(@PathVariable Long id){

        Optional<Order> order = Optional.of(orderRepository.findById(id).get());
        Customer customer = customerRestClientService.customerById(order.get().getCustomerId());
        order.get().setCustomer(customer);

        order.get().getProductItems().forEach(pi ->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;




    }
}
