package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    LowerCategory mapToEntity(LowerCategoryJpaEntity lowerCategoryJpaEntity) {
        LowerCategory lowerCategory = LowerCategory.builder()
                .seq(new LowerCategory.LowerCategorySeq(lowerCategoryJpaEntity.getSeq()))
                .name(LowerCategoryType.valueOf(lowerCategoryJpaEntity.getName()))
                .upperCategorySeq(new UpperCategory.UpperCategorySeq(lowerCategoryJpaEntity.getUpperCategoryJpaEntity().getSeq()))
                .build();
        return lowerCategory;
    }

    UpperCategory mapToEntity(UpperCategoryJpaEntity upperCategoryJpaEntity) {
        UpperCategory upperCategory = UpperCategory.builder()
                .seq(new UpperCategory.UpperCategorySeq(upperCategoryJpaEntity.getSeq()))
                .name(UpperCategoryType.valueOf(upperCategoryJpaEntity.getName()))
                .build();
        return upperCategory;
    }

    LowerCategoryJpaEntity mapToJpaEntity(LowerCategory lowerCategory, UpperCategoryJpaEntity upperCategoryJpaEntity, List<ItemJpaEntity> itemJpaEntityList) {
        LowerCategoryJpaEntity lowerCategoryJpaEntity = LowerCategoryJpaEntity.builder()
                .seq(lowerCategory.getSeq().getValue())
                .name(String.valueOf(lowerCategory.getName()))
                .upperCategoryJpaEntity(upperCategoryJpaEntity)
                .itemJpaEntityList(itemJpaEntityList)
                .build();
        return lowerCategoryJpaEntity;
    }

    UpperCategoryJpaEntity mapToJpaEntity(UpperCategory upperCategory, List<LowerCategoryJpaEntity> lowerCategoryJpaEntityList) {
        UpperCategoryJpaEntity upperCategoryJpaEntity = UpperCategoryJpaEntity.builder()
                .seq(upperCategory.getSeq().getValue())
                .name(String.valueOf(upperCategory.getName()))
                .lowerCategoryJpaEntityList(lowerCategoryJpaEntityList)
                .build();
        return upperCategoryJpaEntity;
    }

}
