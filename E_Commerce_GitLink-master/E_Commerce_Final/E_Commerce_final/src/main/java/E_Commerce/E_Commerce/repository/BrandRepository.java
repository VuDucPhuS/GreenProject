package E_Commerce.E_Commerce.repository;

import org.springframework.data.relational.core.mapping.Table;
import E_Commerce.E_Commerce.Production.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Long> {
}
