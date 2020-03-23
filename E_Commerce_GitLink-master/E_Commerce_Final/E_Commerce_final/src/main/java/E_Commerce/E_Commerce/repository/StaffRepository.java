package E_Commerce.E_Commerce.repository;

import E_Commerce.E_Commerce.Sales.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff,Long> {
}
