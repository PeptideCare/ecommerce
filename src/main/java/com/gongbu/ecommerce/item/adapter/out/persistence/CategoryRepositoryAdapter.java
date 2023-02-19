package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryPort {
    private final LowerCategoryRepository lowerCategoryRepository;
    private final UpperCategoryRepository upperCategoryRepository;

    @Override
    public LowerCategory getLowerCategory(Long lowerCategorySeq) {
        return null;
    }

    @Override
    public UpperCategory getUpperCategory(Long upperCategorySeq) {
        return null;
    }
}
