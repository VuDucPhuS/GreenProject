package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Sales.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,Long> {
}
