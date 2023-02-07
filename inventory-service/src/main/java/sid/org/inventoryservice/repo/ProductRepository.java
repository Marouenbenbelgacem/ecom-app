package sid.org.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import sid.org.inventoryservice.entities.Product;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product, Long> {
}
