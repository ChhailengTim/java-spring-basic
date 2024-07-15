package com.example.customers.computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/computers")
public class ComputerController {

    private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @GetMapping()
    public List<ComputerModel> getComputers(){
        return computerService.getComputers();
    }

    @PostMapping()
    public void addNewComputer(@RequestBody ComputerModel computer){
        computerService.addNewComputer(computer);
    }

    @DeleteMapping(path = "{computerId}")
    public void deleteComputer(@PathVariable("computerId") Long computerId){
        computerService.deleteComputer(computerId);
    }

    @PutMapping(path = "{computerId}")
    public ResponseEntity<ComputerModel> updateComputer(
            @PathVariable("computerId") Long computerId,
            @RequestBody ComputerModel computerDetails
    ){
        return computerService.updateComputer(computerId, computerDetails);
    }
}
