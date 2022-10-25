package lk.ijse.springBoot.controller;

import lk.ijse.springBoot.dto.CustomerDto;
import lk.ijse.springBoot.dto.OrderDto;
import lk.ijse.springBoot.service.CustomerService;
import lk.ijse.springBoot.service.OrderService;
import lk.ijse.springBoot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService ordersService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllOrders(){
        return new ResponseUtil(200,"Done",ordersService.getAllOrders());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveOrder(@RequestBody OrderDto orderDto){
        System.out.println("orderDto");
        System.out.println(orderDto);
        ordersService.purchaseOrder(orderDto);
        return new ResponseUtil(200,"Order Added successfully",null);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateOrder(@RequestBody OrderDto orderDto){
        System.out.println(orderDto);
        ordersService.updateOrder(orderDto);
        return new ResponseUtil(200,"Order updated successfully",null);
    }
    @DeleteMapping(params = {"oid"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteOrder(@RequestParam String oid){
        ordersService.deleteOrder(oid);
        return new ResponseUtil(200,"Order deleted successfully",null);
    }

    @GetMapping(path="/{oid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkAvailability(@PathVariable String oid){
        return new ResponseUtil(200,"Done",ordersService.checkAvailability(oid));
    }


}
