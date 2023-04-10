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
    public Long addItem(ItemRequest itemRequest) {
        LowerCategoryJpaEntity lowerCategoryJpaEntity = categoryPort.getLowerCategoryJpaEntity(itemRequest.getLowerCategorySeq());
        ItemJpaEntity itemJpaEntity = itemRequest.mapToJpaEntity(lowerCategoryJpaEntity);
        return itemPort.addItem(itemJpaEntity);
    }

    @Override
    public Long removeItem(Long itemSeq) {
        return itemPort.removeItem(itemSeq);
    }

    @Override
    public Item getItem(Long itemSeq) {
        Item findItem = itemPort.loadItem(itemSeq);
        return findItem;
    }

    @Override
    public List<Item> getItemList() {
        List<Item> itemList = itemPort.loadItemList();
        System.out.println("Success to Get ItemList");
        return itemList;
    }
}
