package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    Item mapToEntity(ItemJpaEntity itemJpaEntity) {
        Item item = Item.builder()
                .seq(new Item.ItemSeq(itemJpaEntity.getSeq()))
                .stock(itemJpaEntity.getStock())
                .name(itemJpaEntity.getName())
                .rating(itemJpaEntity.getRating())
                .price(itemJpaEntity.getPrice())
                .lowerCategorySeq(new LowerCategory.LowerCategorySeq(itemJpaEntity.getLowerCategorySeq()))
                .build();
        return item;
    }

    ItemJpaEntity mapToJpaEntity(Item item) {
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .seq(item.getSeq().getValue())
                .stock(item.getStock())
                .name(item.getName())
                .rating(item.getRating())
                .price(item.getPrice())
                .lowerCategorySeq(item.getLowerCategorySeq().getValue())
                .build();
        return itemJpaEntity;
    }
}
