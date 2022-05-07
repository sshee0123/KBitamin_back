package com.kb1.springbootback.controller;

import com.kb1.springbootback.exception.ResourceNotFoundException;
import com.kb1.springbootback.model.user.User;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원 정보 가져오기
    @GetMapping("/user")
    // @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    public ResponseEntity<User> getUserById(@RequestParam(value="id") String userid) {
        User user = userService.getUserById(userid);

        if(user == null) {
            throw new ResourceNotFoundException("This user does not already exist.");
        }

       // return new ResponseEntity<User>(HttpStatus.OK);
        return ResponseEntity.ok(user);
    }


    // 회원 정보 업데이트
    @PutMapping("/user/{userId}")
    // @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User updatedUser){
        // email 이미 존재하는지 확인
        // if (userService.existsByEmail(updatedUser.getEmail())) {
        //     throw new ResourceNotFoundException("Error: Email is already in use!");
        // }

        System.out.println("\n\n\n\n\n\n\n update : userid? "+updatedUser.getBirthDate());
        return ResponseEntity.ok(userService.updateUserInfo(userId, updatedUser));
    }

    // 회원 탈퇴
    @DeleteMapping("/user/{userId}")
    @Transactional
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {

        User user = userService.getUserById(userId);

        if (user == null) {
            throw new ResourceNotFoundException("This user does not already exist.");
        }

        userService.deleteUserById(userId);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}