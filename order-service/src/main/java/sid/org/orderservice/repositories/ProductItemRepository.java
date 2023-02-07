package sid.org.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import sid.org.orderservice.entities.ProductItem;

@RepositoryRestController
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {



}
