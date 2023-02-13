package com.gongbu.ecommerce.item.adapter.in.web;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import lombok.Data;

@Data
public class ItemRequest {
    private Long itemId; // PK
    private int stock; // 재고수량
    private String name; // 물품 이름
    private Long price; // 가격
    private Long lowerCategorySeq;

    // add 용 mapper
    public ItemJpaEntity mapToJpaEntity() {
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .stock(stock)
                .name(name)
                .price(price)
                .build();

        return itemJpaEntity;
    }
}
