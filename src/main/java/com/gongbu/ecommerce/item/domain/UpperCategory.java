package com.gongbu.ecommerce.item.domain;


import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class UpperCategory {

    private final UpperCategorySeq seq; // PK
    private final UpperCategoryType name; // 카테고리 이름

    @Value
    public static class UpperCategorySeq {
        private Long value;
    }
}
