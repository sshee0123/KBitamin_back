// package com.example.demo.model.user;

// import lombok.*;

// import javax.persistence.*;
// import javax.validation.constraints.Email;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.Date;
// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @Getter
// @Setter
// @AllArgsConstructor
// @Table(name = "User", uniqueConstraints = {
// 		@UniqueConstraint(columnNames = "user_id"),
// 		@UniqueConstraint(columnNames = "user_email")
// })
// public class User {

// 	// PK: 유저 id
// 	@Id
// 	@Column(name = "user_id")
// 	private String id;

// 	// 유저 이름 ex)엄종석(교수님)
// 	@NotBlank
// 	@Size(max = 20)
// 	@Column(name = "user_name")
// 	private String username;

// 	// 이메일
// 	@NotBlank
// 	@Email
// 	@Size(max = 50)
// 	@Column(name = "user_email")
// 	private String email;

// 	// 비밀번호
// 	@NotNull
// 	@Size(max = 120)
// 	@Column(name = "user_password")
// 	private String password;

// 	// 핸드폰 번호
// 	// @Column(name = "user_phoneNo")
// 	// private String phone;

// 	// // 성별
// 	// @Enumerated(EnumType.STRING)
// 	// @Column(name = "user_sex")
// 	// private ESex sex;

// 	// // 생일
// 	// @Column(name = "user_birthDate")
// 	// private Date birthDate;

// 	// // 가입일
// 	// @Column(name = "user_joinDate", columnDefinition = "datetime default now()")
// 	// private LocalDateTime joinDate;

// 	// // 유저 - 권한
// 	// @ManyToMany(fetch = FetchType.LAZY)
// 	// @JoinTable(name = "UserRole",
// 	// 		joinColumns = @JoinColumn(name = "user_id"),
// 	// 		inverseJoinColumns = @JoinColumn(name = "role_id"))
// 	// private Set<Role> roles = new HashSet<>();

// 	public User() {
// 	}

// 	public User(String username, String email, String password) {
// 		this.username = username;
// 		this.email = email;
// 		this.password = password;
// 	}
// }