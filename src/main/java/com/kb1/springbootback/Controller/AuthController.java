package com.kb1.springbootback.Controller;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	// @Autowired
	// AuthenticationManager authenticationManager;

	// @Autowired
	// UserRepository userRepository;

	// @Autowired
	// RoleRepository roleRepository;

	// @Autowired
	// PasswordEncoder encoder;

	// @Autowired
	// JwtUtils jwtUtils;

	// 로그인
	//@PreAuthorize("permitAll()")
	// @PostMapping("/signin")
	// public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	// 	Authentication authentication = authenticationManager.authenticate(
	// 			new UsernamePasswordAuthenticationToken(loginRequest.getId(), loginRequest.getPassword()));

	// 	SecurityContextHolder.getContext().setAuthentication(authentication);
	// 	String jwt = jwtUtils.generateJwtToken(authentication);

	// 	// 유저 권한 목록들을 리스트 형태로 저장
	// 	UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
	// 	List<String> roles = userDetails.getAuthorities().stream()
	// 			.map(item -> item.getAuthority())
	// 			.collect(Collectors.toList());

	// 	return ResponseEntity.ok(new JwtResponse(jwt,
	// 			userDetails.getId(),
	// 			userDetails.getUsername(),
	// 			userDetails.getEmail(),
	// 			roles));
	// }

	// 회원가입
	//@PreAuthorize("permitAll()")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Validated @RequestBody SavedRequest signUpRequest) {
		System.out.println("\n\n\n\n\nrequest seccess!!!!!!!!!!!! \n\n\n\n");
		System.out.println(signUpRequest);

		return null;

		
		// if (userRepository.existsById(signUpRequest.getId())) {
		// 	return ResponseEntity
		// 			.badRequest()
		// 			.body(new MessageResponse("Error: Id is already in use!"));
		// }

		// if (userRepository.existsByEmail(signUpRequest.getEmail())) {
		// 	return ResponseEntity
		// 			.badRequest()
		// 			.body(new MessageResponse("Error: Email is already in use!"));
		// }

		// if (!signUpRequest.getSex().equals(ESex.N.toString()) && !signUpRequest.getSex().equals(ESex.X.toString()) && !signUpRequest.getSex().equals(ESex.Y.toString()) ) {
		// 	return ResponseEntity
		// 			.badRequest()
		// 			.body(new MessageResponse("Error: Please select your gender!"));
		// }

		// Create new user's account
		//
//      User user = new User.Builder(signUpRequest.getUsername(),
//                     encoder.encode(signUpRequest.getPassword()),
//                     signUpRequest.getEmail())
//                     //.phoneNo(signUpRequest.getPhone())
//                     //.sex(signUpRequest.getSex())
//                     //.birthDate(signUpRequest.getBirthDate())
//                     .build();
		// User user = new User();
		// user.setId(signUpRequest.getId());
		// user.setUsername(signUpRequest.getUsername());
		// user.setPassword(encoder.encode(signUpRequest.getPassword()));
		// user.setEmail(signUpRequest.getEmail());
		// user.setBirthDate(signUpRequest.getBirthDate());
		// user.setPhone(signUpRequest.getPhone());
		// user.setSex(ESex.valueOf(signUpRequest.getSex()));
		// user.setJoinDate(LocalDateTime.now());

		// Set<String> strRoles = signUpRequest.getRoles();
		// Set<Role> roles = new HashSet<>();

		// if (strRoles == null) {
		// 	Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		// 			.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		// 	roles.add(userRole);
		// } else {
		// 	strRoles.forEach(role -> {
		// 		switch (role) {
		// 			case "admin":
		// 				Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
		// 						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		// 				roles.add(adminRole);

		// 				break;
		// 			case "mod":
		// 				Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
		// 						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		// 				roles.add(modRole);

		// 				break;
		// 			default:
		// 				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		// 						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		// 				roles.add(userRole);
		// 		}
		// 	});
		// }

		// user.setRoles(roles);
		// userRepository.save(user);

		// return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}