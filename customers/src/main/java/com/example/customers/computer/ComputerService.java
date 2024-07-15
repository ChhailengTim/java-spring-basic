package com.example.customers.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {
    public final ComputerRepository computerRepository;

    @Autowired
    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public List<ComputerModel> getComputers(){
        return computerRepository.findAll();
    }

    public void addNewComputer(ComputerModel computer) {
        computerRepository.save(computer);
    }

    public void deleteComputer(Long computerId) {
        boolean exists = computerRepository.existsById(computerId);
        if(!exists){
            throw new IllegalStateException("Computer with Id " + computerId + " not exists");
        }
        computerRepository.deleteById(computerId);
    }

    @Transactional
    public ResponseEntity<ComputerModel> updateComputer(Long id, ComputerModel computerDetails) {
        Optional<ComputerModel> optionalComputer = computerRepository.findById(id);

        if (optionalComputer.isPresent()) {
            ComputerModel computer = optionalComputer.get();
            computer.setModel(computerDetails.getModel());
            computer.setBrand(computerDetails.getBrand());
            computer.setYear(computerDetails.getYear());
            computer.setPrice(computerDetails.getPrice());
            ComputerModel updatedComputer = computerRepository.save(computer);
            return ResponseEntity.ok(updatedComputer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
