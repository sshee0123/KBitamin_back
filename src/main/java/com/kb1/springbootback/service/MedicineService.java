package com.kb1.springbootback.service;

import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.model.user.User;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.repository.user.MedicineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    // name으로 Medicine 정보 가져오기
    public Medicine getMedicineByName(String name) {
        return medicineRepository.findAllByName(name);
    }

    // name로 Medicine 있는지 확인
    public Boolean existsByName(String name) {
        return medicineRepository.existsByName(name);
    }

}