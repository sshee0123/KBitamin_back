package com.kb1.springbootback.service;

import java.util.List;

import com.kb1.springbootback.exception.ResourceNotFoundException;
import com.kb1.springbootback.model.medicine.Caution;
import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.repository.medicine.CautionRepository;
import com.kb1.springbootback.repository.medicine.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CautionService {
    
    @Autowired
    private CautionRepository cautionRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    // name( Medicine의 name) 으로 Caution 정보들 가져오기
    public List<Caution> getCautionByMediName(String name){

        return cautionRepository.findAllByName(name);
    }
}

