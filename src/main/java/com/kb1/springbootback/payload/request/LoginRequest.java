package com.kb1.springbootback.payload.request;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {
	@NotBlank
	private String id;

	@NotBlank
	private String password;

}