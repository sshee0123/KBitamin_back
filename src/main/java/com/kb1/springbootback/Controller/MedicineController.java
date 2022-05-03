/*
package com.kb1.springbootback.controller;

import com.kb1.springbootback.exception.ResourceNotFoundException;
import com.kb1.springbootback.model.medicine.Medicine;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    // Medicine 정보 가져오기
    @GetMapping("/medicine")
    // @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    public ResponseEntity<Medicine> getMedicineByName(@RequestParam(value="name") String name) {
      
        Medicine name = medicineService.getMedicineByName(name);

        if(name == null) {
            throw new ResourceNotFoundException("This user does not already exist.");
        }
        return ResponseEntity.ok(name);
    }


    // 회원 정보 업데이트
    @PutMapping("/medicine/{name}")
    // @PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
    public ResponseEntity<Medicine> updateUser(@PathVariable String name, @RequestBody Medicine updatedUser){
        // email 이미 존재하는지 확인
        // if (userService.existsByEmail(updatedUser.getEmail())) {
        //     throw new ResourceNotFoundException("Error: Email is already in use!");
        // }

        System.out.println("\n\n\n\n\n\n\n update : userId? "+userId);
        return ResponseEntity.ok(userService.updateUserInfo(update, updatedUser));
    }

    // 약 정보 받아오기
	@PreAuthorize("permitAll()")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		System.out.println("\n\n\n\n\nrequest success!!!!!!!! \n "+ signUpRequest.getId() +"\n\n\n");
		
		if (userRepository.existsById(signUpRequest.getId())) {
			System.out.println("existsById");
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Id is already in use!"));
		}

		User user = new User();
		user.setId(signUpRequest.getId());
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setEmail(signUpRequest.getEmail());
		user.setBirthDate(signUpRequest.getBirthDate());
		// user.setPhone(signUpRequest.getPhone());
		user.setSex(ESex.valueOf(signUpRequest.getSex()));
		user.setJoinDate(LocalDateTime.now());

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
*/