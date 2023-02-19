package com.gongbu.ecommerce.item.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "upperCategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpperCategoryJpaEntity {
    @Id
    @GeneratedValue
    private Long seq; // PK
    private String name; // 카테고리 이름

    @OneToMany(mappedBy = "upperCategoryJpaEntity")
    private List<LowerCategoryJpaEntity> lowerCategoryJpaEntity;
}
