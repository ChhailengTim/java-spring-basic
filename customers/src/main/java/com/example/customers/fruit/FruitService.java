package com.example.customers.fruit;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public List<FruitModel> getAllFruit() {
        return fruitRepository.findAll();
    }

    public ResponseEntity<FruitModel> addFruit(FruitModel fruitModel) {
        FruitModel addFruit = fruitRepository.save(fruitModel);
        return new ResponseEntity<>(addFruit, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteFruit(Long fruitId) {
        boolean exists = fruitRepository.existsById(fruitId);
        if(!exists){
            throw  new IllegalStateException("Fruit with id "+fruitId+"not exist");
        }else {
            fruitRepository.deleteById(fruitId);
            return new ResponseEntity<>("Fruit deleted successfully",HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity<FruitModel> addNewFruit(Long fruitId, FruitModel fruitDetail) {
        Optional<FruitModel> optionalFruit = fruitRepository.findById(fruitId);
        if(optionalFruit.isPresent()){
            FruitModel fruitModel = optionalFruit.get();
            fruitModel.setName(fruitDetail.getName());
            fruitModel.setPrice(fruitDetail.getPrice());
            FruitModel updateFruit = fruitRepository.save(fruitModel);
            return ResponseEntity.ok(updateFruit);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public Optional<FruitModel> getFruitById(Long fruitId) {
        return fruitRepository.findById(fruitId);
    }
}
