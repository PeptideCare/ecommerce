package com.gongbu.ecommerce.item.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Getter
@RequiredArgsConstructor
public class LowerCategory {

    private final LowerCategorySeq seq; // PK
    private final LowerCategoryType name;  // 카테고리 이름
    @NonNull private final UpperCategory.UpperCategorySeq upperCategorySeq; // 상위 카테고리 PK

    @Value
    public class LowerCategorySeq {
        private Long value;
    }
}
