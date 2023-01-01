package com.gongbu.ecommerce.item.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Getter
public class Item {

    private final ItemSeq seq; // PK
    private final int stock; // 재고수량
    private final String name; // 물품 이름
    private final double rating; // 평점
    private final Long price; // 가격
    @NonNull private LowerCategory.LowerCategorySeq lowerCategorySeq; // 카테고리 PK

    @Value
    public class ItemSeq {
        private Long value;
    }

}
