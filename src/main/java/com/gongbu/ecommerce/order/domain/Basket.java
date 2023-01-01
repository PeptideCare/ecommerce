package com.gongbu.ecommerce.order.domain;

import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Getter
@RequiredArgsConstructor
public class Basket {

    private final BasketSeq seq; // PK
    @NonNull private final Member.MemberSeq memberSeq; // 회원 PK
    @NonNull private final Item.ItemSeq itemSeq; // 물품 PK
    private final int count; // 주문 수량
    private final Long sumPrice; // // 총 금액

    @Value
    public class BasketSeq {
        private Long value;
    }
}
