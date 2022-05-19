package com.kb1.springbootback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.kb1.springbootback.model.user.*;
import com.kb1.springbootback.payload.request.LoginRequest;
import com.kb1.springbootback.payload.request.SignupRequest;
import com.kb1.springbootback.payload.response.JwtResponse;
import com.kb1.springbootback.payload.response.MessageResponse;
import com.kb1.springbootback.repository.user.*;
import com.kb1.springbootback.security.jwt.JwtUtils;
import com.kb1.springbootback.security.services.UserDetailsImpl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	// 로그인
	@PreAuthorize("permitAll()")
	@PostMapping("/signin")
	 public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	 	Authentication authentication = authenticationManager.authenticate(
	 			new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPassword()));

	 	SecurityContextHolder.getContext().setAuthentication(authentication);
	 	String jwt = jwtUtils.generateJwtToken(authentication);

	 	// 유저 권한 목록들을 리스트 형태로 저장
	 	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	 	List<String> roles = userDetails.getAuthorities().stream()
	 			.map(item -> item.getAuthority())
	 			.collect(Collectors.toList());

	 	return ResponseEntity.ok(new JwtResponse(jwt,
	 			userDetails.getId(),
	 			userDetails.getUsername(),
	 			userDetails.getEmail(),
	 			roles));
	}

	// 회원가입
	@PreAuthorize("permitAll()")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest signUpRequest) {
		
		if (userRepository.existsById(signUpRequest.getId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Id is already in use!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		if (!signUpRequest.getSex().equals(ESex.N.toString()) && !signUpRequest.getSex().equals(ESex.F.toString()) && !signUpRequest.getSex().equals(ESex.M.toString()) ) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Please select your gender!"));
		}
		User user = new User();
		user.setId(signUpRequest.getId());
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setEmail(signUpRequest.getEmail());
		user.setBirthDate(signUpRequest.getBirthDate());
		user.setSex(ESex.valueOf(signUpRequest.getSex()));
		user.setJoinDate(LocalDateTime.now());
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}