package com.gongbu.ecommerce.item.domain;

import lombok.*;

@RequiredArgsConstructor
@Data
@Builder
public class Item {

    private final ItemSeq seq; // PK
    private final int stock; // 재고수량
    private final String name; // 물품 이름
    private final double rating; // 평점
    private final Long price; // 가격
    @NonNull private LowerCategory.LowerCategorySeq lowerCategorySeq; // 카테고리 PK

    @Value
    public static class ItemSeq {
        private Long value;
    }

}
