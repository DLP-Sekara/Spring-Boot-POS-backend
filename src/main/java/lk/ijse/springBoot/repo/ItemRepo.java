package lk.ijse.springBoot.repo;

import lk.ijse.springBoot.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {
}
