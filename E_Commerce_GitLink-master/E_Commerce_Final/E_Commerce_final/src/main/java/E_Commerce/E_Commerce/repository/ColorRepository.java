package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Production.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<Color,Long> {
}
