package com.kb1.springbootback.controller;

import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.service.MedicineService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MedicineController{

    @Autowired
    private MedicineService medicineService;

    // paging
    @GetMapping("/mediInfo")
    public ResponseEntity<List<Medicine>> getAllMedicines(){
        System.out.println("\n\n\n\n\n\n\n mapping mediINfo?????? ");
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }

    // crud 
}