package com.example.customers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<CustomerModel> getCustomers(){
        return customerService.getCustomer();
    }

    @PostMapping()
    public void addNewCustomer(@RequestBody CustomerModel customer){
        customerService.addNewCustomers(customer);
    }
}
