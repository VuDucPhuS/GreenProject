package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Sales.Store;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends PagingAndSortingRepository<Store,Long> {
}
