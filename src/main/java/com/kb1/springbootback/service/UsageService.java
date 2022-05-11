package com.kb1.springbootback.service;

import java.util.List;

import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.model.medicine.Usage;
import com.kb1.springbootback.repository.medicine.MedicineRepository;
import com.kb1.springbootback.repository.medicine.UsageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsageService {

    @Autowired
    private UsageRepository usageRepository;

    // name( Medicine의 name) 으로 Usage 정보들 가져오기
    public List<Usage> getAllUsageByName(String name){
        System.out.println("name( Medicine의 name) 으로 Usage 정보들 가져오기SERVICE~~~ NAME IS"+name);
        return usageRepository.findAllByName(name);
    }


    
}
