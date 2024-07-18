package com.example.customers.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<PhoneModel> getAllPhone() {
        return phoneRepository.findAll();
    }

    public void addPhone(PhoneModel phoneModel) {
        phoneRepository.save(phoneModel);
    }

    public void deletePhone(Long phoneId) {
        boolean exists = phoneRepository.existsById(phoneId);
        if(!exists){
            throw new IllegalStateException("Phone with id "+phoneId+"not exists");
        }else {
            phoneRepository.deleteById(phoneId);
        }
    }

    @Transactional
    public ResponseEntity<PhoneModel> updatePhone(Long phoneId, PhoneModel phoneModel) {
        Optional<PhoneModel> optionalPhone = phoneRepository.findById(phoneId);
        if(optionalPhone.isPresent()){
            PhoneModel phone = optionalPhone.get();
            phone.setBrand(phoneModel.getBrand());
            phone.setYear(phoneModel.getYear());
            phone.setModel(phoneModel.getModel());
            phone.setPrice(phoneModel.getPrice());
            PhoneModel updatePhone = phoneRepository.save(phone);
            return ResponseEntity.ok(updatePhone);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
