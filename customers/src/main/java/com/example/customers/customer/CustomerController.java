package com.example.customers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomer(customerId);
    }

    @PutMapping(path = "{customerId}")
    public ResponseEntity<CustomerModel> updateCustomer(
            @PathVariable("customerId") Long customerId,
            @RequestBody CustomerModel customerDetails
    ){
        return customerService.updateCustomer(customerId, customerDetails);
    }

}
