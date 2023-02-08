package com.gongbu.ecommerce.item.application.port.in;


import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.domain.Item;

import java.util.List;

public interface ItemUseCase {

    void addItem(ItemRequest itemRequest);

    void removeItem(String itemId);

    Item getItem();

    List<Item> getItemList();
}
