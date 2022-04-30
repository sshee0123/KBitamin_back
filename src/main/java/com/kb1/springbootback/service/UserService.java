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


    // 회원정보 가져오기
    public User getUserById(String id) {
        return userRepository.findAllById(id);
    }

    // 이메일 존재 여부 확인
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    // 회원 정보 업데이트
    public User updateUserInfo(String updatedId, User updatedUser) {
        User user = userRepository.findAllById(updatedId);

        // id는 변경 불가
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(encoder.encode(updatedUser.getPassword()));
        user.setPhone(updatedUser.getPhone());
        user.setSex(updatedUser.getSex());
        user.setBirthDate(updatedUser.getBirthDate());

        return userRepository.save(user);
    }

    // 회원 탈퇴
    public void deleteUserById(String id) {
        userRepository.delete(userRepository.findAllById(id));
    }
}