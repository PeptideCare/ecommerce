package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.UpperCategory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryPort {
    private final LowerCategoryRepository lowerCategoryRepository;
    private final UpperCategoryRepository upperCategoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public LowerCategory getLowerCategory(Long lowerCategorySeq) {
        Optional<LowerCategoryJpaEntity> findLowerCategoryJpaEntity = lowerCategoryRepository.findById(lowerCategorySeq);
        LowerCategoryJpaEntity lowerCategoryJpaEntity = null;
        try {
            lowerCategoryJpaEntity = findLowerCategoryJpaEntity.get();
        } catch (Exception e) {
            System.out.println("LowerCategory is null");
        }
        return categoryMapper.mapToEntity(lowerCategoryJpaEntity);
    }

    @Override
    public UpperCategory getUpperCategory(Long upperCategorySeq) {
        Optional<UpperCategoryJpaEntity> findUpperCategoryJpaEntity = upperCategoryRepository.findById(upperCategorySeq);
        UpperCategoryJpaEntity upperCategoryJpaEntity = null;
        try {
            upperCategoryJpaEntity = findUpperCategoryJpaEntity.get();
        } catch (Exception e) {
            System.out.println("UpperCategory is null");
        }
        return categoryMapper.mapToEntity(upperCategoryJpaEntity);
    }

    @Override
    public LowerCategoryJpaEntity getLowerCategoryJpaEntity(Long lowerCategorySeq) {
        Optional<LowerCategoryJpaEntity> findLowerCategoryJpaEntity = lowerCategoryRepository.findById(lowerCategorySeq);
        LowerCategoryJpaEntity lowerCategoryJpaEntity = null;
        try {
            lowerCategoryJpaEntity = findLowerCategoryJpaEntity.get();
        } catch (Exception e) {
            System.out.println("LowerCategory is null");
        }
        return lowerCategoryJpaEntity;
    }

    @Override
    public UpperCategoryJpaEntity getUpperCategoryJpaEntity(Long upperCategorySeq) {
        Optional<UpperCategoryJpaEntity> findUpperCategoryJpaEntity = upperCategoryRepository.findById(upperCategorySeq);
        UpperCategoryJpaEntity upperCategoryJpaEntity = null;
        try {
            upperCategoryJpaEntity = findUpperCategoryJpaEntity.get();
        } catch (Exception e) {
            System.out.println("UpperCategory is null");
        }
        return upperCategoryJpaEntity;
    }
}
