package com.kb1.springbootback.controller;

import com.kb1.springbootback.model.medicine.Usage;
import com.kb1.springbootback.service.UsageService;

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
public class UsageController {
    @Autowired
    private UsageService usageService;

    // get one medi caution
    @GetMapping("/medicine/detailOneMediInfo")
    public ResponseEntity<Usage> getOneCautionByMediName(@RequestParam(value = "name") String name){
        System.out.println("\n\n\n\n\n\n\n Usage : medi name is" +name);
            return ResponseEntity.ok(usageService.getUsageByMediName(name));
    }
}
