package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Production.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
