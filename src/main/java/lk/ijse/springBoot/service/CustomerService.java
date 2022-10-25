package lk.ijse.springBoot.service;

import lk.ijse.springBoot.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);
    void deleteCustomer(String nic);
    void updateCustomer(CustomerDto customerDto);
    CustomerDto searchCustomer(String nic);
    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerDetails(String name);
    boolean checkAvailability(String nic);
}
