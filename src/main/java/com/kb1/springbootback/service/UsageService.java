package com.kb1.springbootback.service;

import java.util.List;

import com.kb1.springbootback.model.medicine.Usage;
import com.kb1.springbootback.repository.medicine.UsageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsageService {

    @Autowired
    private UsageRepository usageRepository;

    // name( Medicine의 name) 으로 Usage 정보 하나 가져오기
    public Usage getUsageByMediName(String name){
        return usageRepository.findOneByName(name);
    }

    // name로 Usage 있는지 확인
    public Boolean existsByName(String name) {
        return usageRepository.existsByName(name);
    }
    
    // Usage List 다 가져오기 -> 필요없긴함.
    public List<Usage> findAll(){
        List<Usage> list = usageRepository.findAll();
        System.out.println("Usage List 다 가져오기");
        return list;
    }

    
}
