package com.gongbu.ecommerce.item.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lowerCategory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LowerCategoryJpaEntity {
    @Id
    @GeneratedValue
    private Long seq; // PK
    private String name; // 카테고리 이름

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq")
    private UpperCategoryJpaEntity upperCategoryJpaEntity;

    @OneToMany(mappedBy = "lowerCategoryJpaEntity")
    private List<ItemJpaEntity> itemJpaEntity;
}
