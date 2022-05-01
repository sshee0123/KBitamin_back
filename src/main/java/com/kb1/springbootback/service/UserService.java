package com.kb1.springbootback.service;

import com.kb1.springbootback.model.user.User;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    // id로 user 정보 가져오기
    public User getUserById(String id) {
        return userRepository.findAllById(id);
    }

    // email로 Email 있는지 확인
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    // user update
    public User updateUserInfo(String updatedId, User updatedUser) {
        User user = userRepository.findAllById(updatedId);

        // id 제외하고 update
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(encoder.encode(updatedUser.getPassword()));
        // user.setPhone(updatedUser.getPhone()); // 삭제
        user.setSex(updatedUser.getSex());
        user.setBirthDate(updatedUser.getBirthDate());

        return userRepository.save(user);
    }

    // user delete ( 탈퇴 )
    public void deleteUserById(String id) {
        userRepository.delete(userRepository.findAllById(id));
    }
}