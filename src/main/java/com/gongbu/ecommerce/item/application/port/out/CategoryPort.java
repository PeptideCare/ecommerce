package com.gongbu.ecommerce.item.application.port.out;

import com.gongbu.ecommerce.item.adapter.out.persistence.LowerCategoryJpaEntity;
import com.gongbu.ecommerce.item.adapter.out.persistence.UpperCategoryJpaEntity;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;

public interface CategoryPort {
    LowerCategory getLowerCategory (Long lowerCategorySeq);
    UpperCategory getUpperCategory (Long upperCategorySeq);
    LowerCategoryJpaEntity getLowerCategoryJpaEntity (Long lowerCategorySeq);
    UpperCategoryJpaEntity getUpperCategoryJpaEntity (Long upperCategorySeq);
}
