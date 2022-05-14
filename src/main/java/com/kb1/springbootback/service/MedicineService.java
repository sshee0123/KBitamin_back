package com.kb1.springbootback.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.model.user.User;
import com.kb1.springbootback.payload.response.MessageResponse;import com.kb1.springbootback.repository.medicine.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    // name으로 Medicine 정보 가져오기
    public Medicine getMedicineByName(String name) {
        System.out.println("name으로 Medicine 정보 가져오기  SERVICE~~~ NAME IS"+name);

        return medicineRepository.findOneByName(name);

    }

    // name로 Medicine 있는지 확인
    public Boolean existsByName(String name) {
        return medicineRepository.existsByName(name);
    }

    // medicine LIST 다 가져오기
    public List<Medicine> findAll(){
        List<Medicine> list = medicineRepository.findAll();
        System.out.println("medicine LIST 다 가져오기");
        
        return list;
    }

    // 선택된 리뷰필터링 가져오기, btnId(value), btnName(type)
    // public List<?> getMedicineByHashbtn(String btnId, String btnName) {

    //     switch(btnName){
    //         // 모양
    //         case "shape":
    //         // 색상
    //         case "color":
    //         // 제형
    //         case "formulation":
    //         // 분할선 
    //         case "divide_line":
    //     }

    //     return result;

    // }

}
