package sid.org.orderservice.services;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sid.org.orderservice.model.Customer;
import sid.org.orderservice.model.Product;;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {

    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);

    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();


}
