package lk.ijse.springBoot.repo;

import lk.ijse.springBoot.entity.Item;
import lk.ijse.springBoot.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String> {
}
