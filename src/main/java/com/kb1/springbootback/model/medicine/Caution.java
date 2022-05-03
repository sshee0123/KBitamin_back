package com.kb1.springbootback.model.medicine;

import java.io.Serializable;
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
@Table(name="caution")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class Caution implements Serializable{

    // 주의사항_인덱스
    @Id
    @Column(name = "caution_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cautionIdx;
    
    // 주의사항_내용
    @Column(name = "caution_content")
    private String cautionContent;

    // // 제품명(외래키)
    // @ManyToOne
    // @JoinColumn(name = "name")
    // private Medicine name;
}
