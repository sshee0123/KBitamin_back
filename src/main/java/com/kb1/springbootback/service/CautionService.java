package com.kb1.springbootback.service;

import java.util.List;

import com.kb1.springbootback.model.medicine.Caution;
import com.kb1.springbootback.repository.medicine.CautionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CautionService {
    
    @Autowired
    private CautionRepository cautionRepository;

    // name( Medicine의 name) 으로 Caution 정보 하나 가져오기
    public Caution getCautionByMediName(String name){
        return cautionRepository.findOneByName(name);
    }

    // name로 Caution 있는지 확인
    public Boolean existsByName(String name) {
        return cautionRepository.existsByName(name);
    }
    
    // Caution List 다 가져오기 -> 필요없긴함.
    public List<Caution> findAll(){
        List<Caution> list = cautionRepository.findAll();
        System.out.println("caution List 다 가져오기");
        return list;
    }



}
