package com.gongbu.ecommerce.item.adapter.in.web;

import com.gongbu.ecommerce.item.application.port.in.ItemUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemUseCase itemUseCase;

    // 물품 추가
    @PostMapping("/ecommerce/item/add")
    public void addItem(
            @RequestBody ItemRequest itemRequest) {
        itemUseCase.addItem(itemRequest);
    }

    // 물품 삭제
    @DeleteMapping("/ecommerce/item/remove/{itemId}")
    public void removeItem(
            @PathVariable ("itemId") Long itemId) {
        itemUseCase.removeItem(itemId);
    }

    // 물품 불러오기
    @GetMapping("/ecommerce/item/get/{itemId}")
    public void getItem(
            @PathVariable ("itemId") Long itemId) {
        itemUseCase.getItem(itemId);
    }

    // 물품 불러오기
    @GetMapping("/ecommerce/item/get/all")
    public void getItemList() {
        itemUseCase.getItemList();
    }
}
