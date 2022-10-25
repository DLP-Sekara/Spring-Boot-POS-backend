package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void purchaseOrder(OrderDto dto);

    void deleteOrder(String oid);

    void updateOrder(OrderDto dto);

    OrderDto searchOrder(String oid);

    List<OrderDto> getAllOrders();

    boolean checkAvailability(String oid);
}
