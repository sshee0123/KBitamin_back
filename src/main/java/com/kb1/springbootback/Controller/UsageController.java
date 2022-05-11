package com.kb1.springbootback.controller;

import java.util.List;

import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.model.medicine.Usage;
import com.kb1.springbootback.service.UsageService;

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
@RequestMapping("/api/medicine")
// @RequestMapping("/api/medicine/detailOneMediInfo")
public class UsageController {

    @Autowired
    private UsageService usageService;

    // // get one medi usages
    // @GetMapping("/detailUsageMediInfo")
    // public List<Usage> getUsageByMediName(@RequestParam("name") String name){
    //     System.out.println("\n\n\n\n\n\n\n Usage : medi name is" +name);
    //         return usageService.getAllUsageByName(name);
    // }

        // // get one medi usages
        // @GetMapping("/detailUsageMediInfo")
        // // @GetMapping("/detailOneMediInfo")
        // public ResponseEntity<List<Usage>> getAllUsageByName(@RequestParam(value="name") String name){
        //     System.out.println("\n\n\n\n\n\n\n Usage : medi name is" +name);
        //     List<Usage> usages = usageService.getAllUsageByName(name);
        //     System.out.println("\n\n\n\n\n\n\n Usage List" +usages);
        //     return ResponseEntity.ok().body(usages);
        // }
}
