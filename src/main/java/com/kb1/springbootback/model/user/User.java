package com.kb1.springbootback.model.user;

import java.util.*;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "User", uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_id"),
		@UniqueConstraint(columnNames = "user_email")
})
public class User {

	// PK: user_id
	@Id
	@Column(name = "user_id")
	private String id;

	// user_name
	@NotBlank
	@Size(max = 20)
	@Column(name = "user_name")
	private String username;

	// user_email
	@NotBlank
	@Email
	@Size(max = 50)
	@Column(name = "user_email")
	private String email;

	// user_password
	@NotNull
	@Size(max = 120)
	@Column(name = "user_password")
	private String password;

	// user_phoneNo
	@Column(name = "user_phoneNo")
	private String phone;

	// user_sex
	@Enumerated(EnumType.STRING)
	@Column(name = "user_sex")
	private ESex sex;

	// user_birthDate
	@Column(name = "user_birthDate")
	private Date birthDate;

	// 가입일
	@Column(name = "user_joinDate", columnDefinition = "datetime default now()")
	private LocalDateTime joinDate;

	// 유저 - 권한
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "UserRole",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
}