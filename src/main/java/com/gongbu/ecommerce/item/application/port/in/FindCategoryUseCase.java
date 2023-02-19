package com.gongbu.ecommerce.item.application.port.in;

import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;

public interface FindCategoryUseCase {
    public LowerCategory getLowerCategory(Long lowerCategorySeq);
    public UpperCategory getUpperCategory(Long upperCategorySeq);
}
