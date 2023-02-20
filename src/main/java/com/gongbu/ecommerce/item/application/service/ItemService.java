package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.adapter.out.persistence.ItemMapper;
import com.gongbu.ecommerce.item.adapter.out.persistence.LowerCategoryJpaEntity;
import com.gongbu.ecommerce.item.application.port.in.ItemUseCase;
import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.item.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService implements ItemUseCase {

    private final ItemPort itemPort;
    private final CategoryPort categoryPort;

    @Override
    public void addItem(ItemRequest itemRequest) {
        LowerCategoryJpaEntity lowerCategoryJpaEntity = categoryPort.getLowerCategoryJpaEntity(itemRequest.getLowerCategorySeq());
        ItemJpaEntity itemJpaEntity = itemRequest.mapToJpaEntity(lowerCategoryJpaEntity);
        itemPort.addItem(itemJpaEntity);
        System.out.println("Success to Add Item");
    }

    @Override
    public void removeItem(Long itemId) {
        itemPort.removeItem(itemId);
        System.out.println("Success to Remove Item");
    }

    @Override
    public Item getItem(Long itemId) {
        Item findItem = itemPort.loadItem(itemId);
        System.out.println("Success to Get Item");
        return findItem;
    }

    @Override
    public List<Item> getItemList() {
        List<Item> itemList = itemPort.loadItemList();
        System.out.println("Success to Get ItemList");
        return itemList;
    }
}
