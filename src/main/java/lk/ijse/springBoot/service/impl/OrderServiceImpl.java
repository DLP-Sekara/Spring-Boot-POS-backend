package lk.ijse.springBoot.service.impl;

import lk.ijse.springBoot.dto.OrderDto;
import lk.ijse.springBoot.entity.Orders;
import lk.ijse.springBoot.repo.OrderRepo;
import lk.ijse.springBoot.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo ordersRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void purchaseOrder(OrderDto dto) {
        if (!ordersRepo.existsById(dto.getOid())) {
            Orders order = mapper.map(dto, Orders.class);
            ordersRepo.save(order);

            if (dto.getOrderDetails().size() < 1) throw new RuntimeException("No items added for the order..!");

            //update the item
            /*for (OrderDetails orderDetail : order.getOrderDetails()) {
                Item item = itemRepo.findById(orderDetail.getItemCode()).get();
                item.setQty(item.getQty() - orderDetail.getQty());
                itemRepo.save(item);
            }*/

        } else {
            throw new RuntimeException("Purchase Order Failed..!, Order ID " + dto.getOid() + " Already Exist.!");
        }
    }

    @Override
    public void deleteOrder(String oid) {

    }

    @Override
    public void updateOrder(OrderDto dto) {

    }

    @Override
    public OrderDto searchOrder(String oid) {
        return null;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return mapper.map(ordersRepo.findAll(), new TypeToken<List<OrderDto>>() {
        }.getType());
    }

    @Override
    public boolean checkAvailability(String oid) {
        return false;
    }
}
