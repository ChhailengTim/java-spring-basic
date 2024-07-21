package com.example.customers.feeling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeelRepository extends JpaRepository<FeelModel, Long> {

}
