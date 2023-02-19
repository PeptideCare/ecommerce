package com.gongbu.ecommerce.item.application.port.out;

import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;

public interface CategoryPort {
    LowerCategory getLowerCategory (Long lowerCategorySeq);
    UpperCategory getUpperCategory (Long upperCategorySeq);
}
