package com.kb1.springbootback.model.medicine;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import java.time.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@ToString
@Entity
@Table(name="medicine")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class Medicine implements Serializable {

    // 약 이름
    @Id
    @Column(name = "name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    // 제형
    @Column(name = "formulation")
    private String formulation;

    // 모양
    @Column(name = "shape")
    private String shape;

    // 제조업체
    @Column(name = "manufacturer")
    private String manufacturer;

    // 유효성분
    @Column(name = "ingredient")
    private String ingredient;

    // 효능
    @Column(name = "efficacy")
    private String efficacy;

    // 이미지
    @Column(name = "image_url")
    private String imageUrl;

    // 색상
    @Column(name = "color")
    private String color;

    // 분할선
    @Column(name = "divide_line")
    private String divideLine;

    // 확인
    // @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    // @Transient
    // public List<Usage> usages = new ArrayList<>();
    // public List<Caution> cautions = new ArrayList<>();

	public Medicine(String name, String formulation, String manufacturer) {
		this.name = name;
		this.formulation = formulation;
		this.manufacturer = manufacturer;
	}
}
