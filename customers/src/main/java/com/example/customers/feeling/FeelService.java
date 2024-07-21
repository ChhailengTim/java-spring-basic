package com.example.customers.feeling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeelService {
    private final FeelRepository feelRepository;

    @Autowired
    public FeelService(FeelRepository feelRepository) {
        this.feelRepository = feelRepository;
    }

    public List<FeelModel> getFeel() {
        return feelRepository.findAll();
    }

    public ResponseEntity<FeelModel> addFeel(FeelModel feelModel) {
        feelRepository.save(feelModel);
        return new ResponseEntity<>(feelModel, HttpStatus.OK);
    }

    public ResponseEntity<FeelModel> updateFeel(Long feelId, FeelModel feelDetail) {
        Optional<FeelModel> optionalFeel = feelRepository.findById(feelId);
        if(optionalFeel.isPresent()){
            FeelModel updateFeel = optionalFeel.get();
            updateFeel.setMood(feelDetail.getMood());
            FeelModel addUpdateFeel = feelRepository.save(updateFeel);
            return new ResponseEntity<>(addUpdateFeel,HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteFeel(Long feelId) {
        feelRepository.deleteById(feelId);
        return new ResponseEntity<>("Feel with " + feelId + "was deleted",HttpStatus.OK);
    }
}
