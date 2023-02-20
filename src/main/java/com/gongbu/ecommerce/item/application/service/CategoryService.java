package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.application.port.in.FindCategoryUseCase;
import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements FindCategoryUseCase {

    private final CategoryPort categoryPort;

    @Override
    public LowerCategory getLowerCategory(Long lowerCategorySeq) {
        return categoryPort.getLowerCategory(lowerCategorySeq);
    }

    @Override
    public UpperCategory getUpperCategory(Long upperCategorySeq) {
        return categoryPort.getUpperCategory(upperCategorySeq);
    }


}
