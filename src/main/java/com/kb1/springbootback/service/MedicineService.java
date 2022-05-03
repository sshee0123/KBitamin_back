package com.kb1.springbootback.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.repository.medicine.MedicineRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MedicineService {
    
    @Autowired
    private MedicineRepository medicineRepository;

    // medicine LIST 다 가져오기
    public List<Medicine> getAllMedicines(){
        return medicineRepository.findAll();
    }

    // 하나씩 다 가져오기
    // public Medicine getMedicine(String name){
    //     Medicine medicine = medicineRepository.findBy(name).orElseThrow(() -> new ResourceNotFoundException("Not exist Medicine Data by name : ["+name+"]"));
        
    //     return medicineRepository.save(medicine);
    // }


}
