package lk.ijse.springBoot.repo;

import lk.ijse.springBoot.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,String> {
}
