package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.application.port.in.ItemUseCase;
import com.gongbu.ecommerce.item.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements ItemUseCase {

    @Override
    public void addItem(ItemRequest itemRequest) {

    }

    @Override
    public void removeItem(String itemId) {

    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public List<Item> getItemList() {
        return null;
    }
}
