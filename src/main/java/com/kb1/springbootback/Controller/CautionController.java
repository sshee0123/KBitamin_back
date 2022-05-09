package com.kb1.springbootback.controller;

import com.kb1.springbootback.model.medicine.Caution;
import com.kb1.springbootback.service.CautionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CautionController {
    
    @Autowired
    private CautionService cautionService;

    // get one medi caution
    @GetMapping("/medicine/detailOneMediInfo")
    public ResponseEntity<Caution> getOneCautionByMediName(@RequestParam(value = "name") String name){
        System.out.println("\n\n\n\n\n\n\n Caution : medi name is" +name);
            return ResponseEntity.ok(cautionService.getCautionByMediName(name));
    }

}
