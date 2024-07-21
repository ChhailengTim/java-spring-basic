package com.example.customers.feeling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/feel")
public class FeelController {

    private final FeelService feelService;

    @Autowired
    public FeelController(FeelService feelService) {
        this.feelService = feelService;
    }

    @GetMapping()
    public List<FeelModel> getFeel(){
        return feelService.getFeel();
    }

    @PostMapping()
    public ResponseEntity<FeelModel> addFeel(@RequestBody FeelModel feelModel){
        return feelService.addFeel(feelModel);
    }

    @PutMapping(path = "{feelId}")
    public ResponseEntity<FeelModel> updateFeel(
            @PathVariable("feelId") Long feelId,
            @RequestBody FeelModel feelDetail
    ){
        return feelService.updateFeel(feelId,feelDetail);
    }

    @DeleteMapping(path = "{feelId}")
    public ResponseEntity<String> deleteFeel(
            @PathVariable("feelId") Long feelId
    ){
        return feelService.deleteFeel(feelId);
    }
}
