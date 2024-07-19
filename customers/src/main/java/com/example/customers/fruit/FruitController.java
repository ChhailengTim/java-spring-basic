package com.example.customers.fruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/fruits")
public class FruitController {
    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping()
    public List<FruitModel> getAllFruit(){
        return fruitService.getAllFruit();
    }

    @GetMapping(path = "/{fruitId}")
    public Optional<FruitModel> getFruitById(
            @PathVariable("fruitId") Long fruitId){
        return fruitService.getFruitById(fruitId);
    }

    @PostMapping()
    public ResponseEntity<FruitModel> addFruit(@RequestBody FruitModel fruitModel){
        return fruitService.addFruit(fruitModel);

    }

    @DeleteMapping(path = "{fruitId}")
    public ResponseEntity<String>  deleteFruit(@PathVariable("fruitId") Long fruitId){
        return fruitService.deleteFruit(fruitId);
    }

    @PutMapping(path = "{fruitId}")
    public ResponseEntity<FruitModel> addNewFruit(
            @PathVariable("fruitId") Long fruitId,
            @RequestBody FruitModel fruitDetail){
        return fruitService.addNewFruit(fruitId, fruitDetail);
    }
}
