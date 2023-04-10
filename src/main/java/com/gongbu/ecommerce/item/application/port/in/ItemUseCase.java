package com.gongbu.ecommerce.item.application.port.in;


import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.domain.Item;

import java.util.List;

public interface ItemUseCase {

    Long addItem(ItemRequest itemRequest);

    Long removeItem(Long itemId);

    Item getItem(Long itemId);

    List<Item> getItemList();
}
