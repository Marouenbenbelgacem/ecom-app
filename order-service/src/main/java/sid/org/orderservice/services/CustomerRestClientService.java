package sid.org.orderservice.services;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sid.org.orderservice.model.Customer;

import java.util.List;

@FeignClient(name = "customer-service")

public interface CustomerRestClientService {

    @GetMapping("/customers/{id}?projection=fullCustomer")
    public Customer customerById(@PathVariable Long id);

    @GetMapping("/customers?projection=fullCustomer")
    public PagedModel<Customer> allCustomers();


}
