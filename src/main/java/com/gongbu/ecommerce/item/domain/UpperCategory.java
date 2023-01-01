package com.gongbu.ecommerce.item.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Getter
@RequiredArgsConstructor
public class UpperCategory {

    private final UpperCategorySeq seq; // PK
    private final UpperCategoryType name; // 카테고리 이름

    @Value
    public class UpperCategorySeq {
        private Long value;
    }
}
