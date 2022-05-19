package com.kb1.springbootback.controller;

import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.repository.medicine.MedicineRepository;
import com.kb1.springbootback.service.MedicineService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/medicine")
public class MedicineController{

    @Autowired
    private MedicineService medicineService;
  
    // 약 정보 모두 가져오기
    @GetMapping("/mediInfo")
    public ResponseEntity<List<Medicine>> getAllMedicines(){
        return ResponseEntity.ok(medicineService.findAll());
    }

    // 약 이름으로 해당 약 정보 하나 가져오기
    @GetMapping("/detailOneMediInfo")
    public ResponseEntity<Medicine> getOneMedicineByName(@RequestParam(value="name", required=false) String name){
        return ResponseEntity.ok(medicineService.getMedicineByName(name));
    }

    // 외형 정보로 버튼 필터링 약 정보 검색
    @GetMapping("/buttonFilter")
    public ResponseEntity<?> getMedicineByButtonFilter(@RequestParam(value="shapeId", required=false) String shapeId,
    @RequestParam(value="colorId", required=false) String colorId,
    @RequestParam(value="formulationId", required=false) String formulationId,
    @RequestParam(value="dividelineId", required=false) String dividelineId){
        return ResponseEntity.ok(medicineService.getMedicineByButtonFilter(shapeId, colorId, formulationId, dividelineId));
    }
}
