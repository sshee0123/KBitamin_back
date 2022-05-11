package com.kb1.springbootback.controller;

import java.util.List;

import com.kb1.springbootback.model.medicine.Caution;
import com.kb1.springbootback.service.CautionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/medicine/detailCautionMediInfo")
// @RequestMapping("/api/medicine/detailOneMediInfo")
public class CautionController {
    
    @Autowired
    private CautionService cautionService;

    // get one medi cautions
    // @GetMapping("/{name}")
    // public List<Caution> getCautionByMediName(@PathVariable String name){
    //     System.out.println("\n\n\n\n\n\n\n Caution : medi name is" +name);
    //         return cautionService.getCautionByMediName(name);
    // }

}
