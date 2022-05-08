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
    @Column(name = "index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String usageIndex;
    
    // 용법_내용
    @Column(name = "content")
    private String usageContent;

    // 제품명(외래키)
    @ManyToOne
    @JoinColumn(name = "name")
    private Medicine name;

    public Usage(Medicine name, String usageIndex, String usageContent){
        this.name = name;
        this.usageIndex = usageContent;
        this.usageContent = usageContent;
    }
}
