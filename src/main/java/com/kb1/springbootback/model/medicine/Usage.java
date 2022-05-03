package com.kb1.springbootback.model.medicine;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usage")
@DynamicInsert
@DynamicUpdate
public class Usage implements Serializable {
    
    // 용법_인덱스
    @Id
    @Column(name = "usage_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usageIdx;
    
    // 용법_내용
    @Column(name = "usage_content")
    private String usageContent;

    // // 제품명(외래키)
    // @ManyToOne
    // @JoinColumn(name = "name")
    // private Medicine name;

}
