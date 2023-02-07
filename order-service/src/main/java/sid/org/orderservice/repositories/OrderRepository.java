package sid.org.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import sid.org.orderservice.entities.Order;

import java.util.List;

@RepositoryRestController
public interface OrderRepository extends JpaRepository<Order, Long> {

    @RestResource(path = "/byCustomerId")
    List<Order> getOrderByCustomerId(@Param("customerId") Long customerId);
}
