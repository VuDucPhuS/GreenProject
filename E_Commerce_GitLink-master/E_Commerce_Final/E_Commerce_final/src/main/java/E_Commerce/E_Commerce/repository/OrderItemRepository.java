package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Sales.OrderItems;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItems,Long> {
}
