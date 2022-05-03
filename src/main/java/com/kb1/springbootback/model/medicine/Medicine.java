package com.kb1.springbootback.model.medicine;

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
@Table(name = "Medicine", uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")
        // ,@UniqueConstraint(columnNames = "user_email")
})
public class Medicine {

	// PK: name
	// @Id
	@Column(name = "name")
	private String name;

	// formulation
	// @NotBlank
	// @Size(max = 100)
	@Column(name = "formulation")
	private String formulation;

	// shape
	// @NotBlank
	// @Size(max = 50)
	@Column(name = "shape")
	private String shape;

	// manufacturer
	// @NotNull
	// @Size(max = 120)
	@Column(name = "manufacturer")
	private String manufacturer;

	// efficacy
	@Column(name = "efficacy")
	private String efficacy;

	// image_url
	@Column(name = "image_url")
	private String image_url;

	// color
	@Column(name = "color")
	private String color;

	// divide_line
	@Column(name = "divide_line")
	private String divide_line;

	// divide_line
	@Column(name = "ingredient")
	private String ingredient;

	public Medicine() {
	}

	public Medicine(String name, String formulation, String manufacturer) {
		this.name = name;
		this.formulation = formulation;
		this.manufacturer = manufacturer;
	}
}