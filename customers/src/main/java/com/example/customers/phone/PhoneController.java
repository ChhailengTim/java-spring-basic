package com.example.customers.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/phones")
public class PhoneController {
    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping()
    public List<PhoneModel> getAllPhone(){
        return phoneService.getAllPhone();
    }

    @PostMapping()
    public void addNewPhone(@RequestBody PhoneModel phoneModel){
        phoneService.addPhone(phoneModel);
    }

    @DeleteMapping(path = "{phoneId}")
    public void deletePhone(@PathVariable("phoneId") Long phoneId){
        phoneService.deletePhone(phoneId);
    }

    @PutMapping(path = "{phoneId}")
    public ResponseEntity<PhoneModel> updatePhone(
            @PathVariable("phoneId") Long phoneId,
            @RequestBody PhoneModel phoneModel){
        return phoneService.updatePhone(phoneId, phoneModel);
    }
}
