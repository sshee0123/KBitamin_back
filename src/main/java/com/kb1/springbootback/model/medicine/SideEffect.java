package com.kb1.springbootback.model.medicine;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@ToString
@Entity
@Table(name="side_effect")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class SideEffect implements Serializable {

    // 약 이름
    @Id
    @Column(name = "name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;

    // 부작용 내용
    @Column(name = "classify")
    private String classify;

    // // 외래키
    // @JoinColumn(name = "user_id_fk")
    // private Calendar user_id;

	// public SideEffect(String name, String content, Calendar user_id) {
	// 	this.name = name;
	// 	this.content = content;
	// 	this.user_id = user_id;
	// }
    public SideEffect(String name, String classify) {
		this.name = name;
		this.classify = classify;
	}
}
