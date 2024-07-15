package com.example.customers.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    public final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerModel> getCustomer(){
        return customerRepository.findAll();
    }

    public void addNewCustomers(CustomerModel customer) {
        Optional<CustomerModel> customerOptional= customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){
            throw new IllegalStateException("Customer with Id " + customerId + " not exists");
        }
        customerRepository.deleteById(customerId);
    }

    @Transactional
    public ResponseEntity<CustomerModel> updateCustomer(Long id, CustomerModel customerDetails) {
        Optional<CustomerModel> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isPresent()) {
            CustomerModel customer = optionalCustomer.get();
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setAge(customerDetails.getAge());
            CustomerModel updatedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
