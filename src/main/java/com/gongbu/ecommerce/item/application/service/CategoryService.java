package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.application.port.in.FindCategoryUseCase;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements FindCategoryUseCase {

    @Override
    public LowerCategory getLowerCategory(Long lowerCategorySeq) {
        return null;
    }

    @Override
    public UpperCategory getUpperCategory(Long upperCategorySeq) {
        return null;
    }
}
