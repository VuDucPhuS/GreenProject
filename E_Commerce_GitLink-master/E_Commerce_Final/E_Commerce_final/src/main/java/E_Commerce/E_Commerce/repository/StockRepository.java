package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Production.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock,Long> {
}
