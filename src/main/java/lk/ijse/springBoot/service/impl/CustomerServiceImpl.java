package lk.ijse.springBoot.service.impl;

import lk.ijse.springBoot.dto.CustomerDto;
import lk.ijse.springBoot.entity.Customer;
import lk.ijse.springBoot.repo.CustomerRepo;
import lk.ijse.springBoot.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        if(!repo.existsById(customerDto.getNic())){
            Customer customerEntity=mapper.map(customerDto,Customer.class);
            repo.save(customerEntity);
        }else{
            throw new RuntimeException("CustomerAlready Exists!");
        }
    }

    @Override
    public void deleteCustomer(String nic) {
        if(repo.existsById(nic)){
           repo.deleteById(nic);
        }else{
            throw new RuntimeException("No Such customer");
        }
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        if(repo.existsById(customerDto.getNic())){
            Customer customer=mapper.map(customerDto,Customer.class);
            repo.save(customer);
        }else{
            throw new RuntimeException("No such customer");
        }
    }

    @Override
    public CustomerDto searchCustomer(String nic) {
        if(repo.existsById(nic)){
            Customer customer=repo.findById(nic).get();
            CustomerDto customerDto=mapper.map(customer,CustomerDto.class);
            return customerDto;
        }else{
            throw new RuntimeException("No Customer");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> all=repo.findAll();
        return mapper.map(all,new TypeToken<List<CustomerDto>>(){}.getType());
    }

    @Override
    public CustomerDto getCustomerDetails(String name) {
        Customer temp=repo.findCustomerByName(name);
        CustomerDto map = mapper.map(temp, CustomerDto.class);
        return map;
    }
    @Override
    public boolean checkAvailability(String nic) {
        return repo.existsById(nic);
    }
}
