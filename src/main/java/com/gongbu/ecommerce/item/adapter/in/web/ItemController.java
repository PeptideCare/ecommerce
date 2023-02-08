package com.gongbu.ecommerce.item.adapter.in.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    // 물품 추가
    @PostMapping("/ecommerce/item/add")
    public void addItem(
            @RequestBody ItemRequest itemRequest) {

    }

    // 물품 삭제
    @DeleteMapping("/ecommerce/item/remove/{itemId}")
    public void removeItem(
            @PathVariable ("itemId") Long itemId) {

    }

    // 물품 불러오기
    @GetMapping("/ecommerce/item/get/{itemId}")
    public void getItem(
            @PathVariable ("itemId") Long itemId) {

    }

    // 물품 불러오기
    @GetMapping("/ecommerce/item/get/all")
    public void getItemList() {

    }
}
