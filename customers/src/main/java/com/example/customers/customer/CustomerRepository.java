package com.example.customers.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    @Query("SELECT s FROM CustomerModel s WHERE s.email = ?1")
    Optional<CustomerModel> findCustomerByEmail(String email);
}
