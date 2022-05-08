package com.kb1.springbootback.model.medicine;

import java.io.Serializable;
import lombok.*;
import javax.persistence.*;
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
    @Column(name = "index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cautionIndex;
    
    // 주의사항_내용
    @Column(name = "content")
    private String cautionContent;

    // 제품명(외래키)
    @ManyToOne
    @JoinColumn(name = "name")
    private Medicine name;

    public Caution(Medicine name, String cautionIndex, String cautionContent){
        this.name = name;
        this.cautionIndex = cautionIndex;
        this.cautionContent = cautionContent;
    }
}
