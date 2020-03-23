package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Sales.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client,Long> {
}
