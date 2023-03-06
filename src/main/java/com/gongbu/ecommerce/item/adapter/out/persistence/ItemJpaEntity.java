package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.order.adapter.out.persistence.BasketJpaEntity;
import com.gongbu.ecommerce.order.adapter.out.persistence.OrderJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "itemJpaEntity")
    private List<BasketJpaEntity> basketJpaEntityList;

    @OneToMany(mappedBy = "itemJpaEntity")
    private List<OrderJpaEntity> orderJpaEntityList;

    @OneToMany(mappedBy = "boardJpaEntity")
    private List<BoardJpaEntity> boardJpaEntityList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq")
    private LowerCategoryJpaEntity lowerCategoryJpaEntity;
}
