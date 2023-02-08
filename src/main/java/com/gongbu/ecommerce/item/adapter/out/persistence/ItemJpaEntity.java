package com.gongbu.ecommerce.item.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemJpaEntity {
    @Id
    @GeneratedValue
    private Long seq; // PK
    private int stock; // 재고수량
    private String name; // 물품 이름
    private double rating; // 평점
    private Long price; // 가격
    private Long lowerCategorySeq; // 카테고리 seq
}
