package com.gongbu.ecommerce.item.application.port.out;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.domain.Item;

import java.util.List;

public interface ItemPort {

    void addItem(ItemJpaEntity itemJpaEntity);
    Item loadItem(Long itemId);
    void removeItem(Long itemId);
    List<Item> loadItemList();
}
