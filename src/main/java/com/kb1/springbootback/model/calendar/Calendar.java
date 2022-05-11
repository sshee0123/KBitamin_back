package com.kb1.springbootback.model.calendar;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@ToString
@Entity
@Table(name="taking")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class Calendar implements Serializable {
    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "user_id")
    private String userid;

    
    @Column(name = "sideEffect_name")
    private String sideEffect_name;

    // start date
    @Column(name = "start")
    private Date start;

    // end date
    @Column(name = "end")
    private Date end;

    // color
    @Column(name = "color")
    private String color;

	public Calendar(String userid, String title, Date end,  Date start, String color) {
		this.userid = userid;
        this.title = title;
		this.start = start;
		this.end = end;
		this.color = color;
	}
}
