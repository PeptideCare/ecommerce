package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.LowerCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    LowerCategory mapToEntity(LowerCategoryJpaEntity lowerCategoryJpaEntity) {
        LowerCategory lowerCategory = LowerCategory.builder()
                .seq(lowerCategoryJpaEntity.getSeq())
    }
}
