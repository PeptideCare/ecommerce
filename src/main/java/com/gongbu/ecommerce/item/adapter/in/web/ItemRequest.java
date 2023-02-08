package com.gongbu.ecommerce.item.adapter.in.web;

import lombok.Data;

@Data
public class ItemRequest {
    private int stock; // 재고수량
    private String name; // 물품 이름
    private Long price; // 가격
}
