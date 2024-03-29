package com.gongbu.ecommerce.item.application.port.out;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.domain.Item;

import java.util.List;

public interface ItemPort {

    Long addItem(ItemJpaEntity itemJpaEntity);
    Item loadItem(Long itemSeq);

    ItemJpaEntity loadItemJpaEntity(Long itemSeq);
    Long removeItem(Long itemSeq);
    List<Item> loadItemList();
}
