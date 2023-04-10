package com.gongbu.ecommerce.item.adapter.in.web;

import com.gongbu.ecommerce.item.application.port.in.ItemUseCase;
import com.gongbu.ecommerce.item.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemUseCase itemUseCase;

    // 물품 추가
    @PostMapping("/ecommerce/item/add")
    public Long addItem(
            @RequestBody ItemRequest itemRequest) {
        return itemUseCase.addItem(itemRequest);
    }

    // 물품 삭제
    @DeleteMapping("/ecommerce/item/remove/{itemId}")
    public Long removeItem(
            @PathVariable ("itemId") Long itemId) {
        return itemUseCase.removeItem(itemId);
    }

    // 물품 불러오기
    @GetMapping("/ecommerce/item/get/{itemId}")
    public Item getItem(
            @PathVariable ("itemId") Long itemId) {
        return itemUseCase.getItem(itemId);
    }

    // 물품 불러오기
    @GetMapping("/ecommerce/item/get/all")
    public List<Item> getItemList() {
        return itemUseCase.getItemList();
    }
}
