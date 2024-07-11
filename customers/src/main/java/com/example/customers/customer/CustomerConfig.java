package com.example.customers.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
          CustomerModel dara = new CustomerModel("Dara","dara@gmail.com",35);
          CustomerModel mara = new CustomerModel("Mara","mara@gmail.com",35);
          repository.saveAll(List.of(dara,mara));
        };

    }
}
