package com.gongbu.ecommerce.order.domain;

import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.member.domain.Member;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Order {
    private final OrderSeq seq; // PK
    @NonNull private final Member.MemberSeq memberSeq; // 회원 PK
    @NonNull private final Item.ItemSeq itemSeq; // 물품 PK
    private final int count;  // 주문 수량
    private final Long sumPrice; // 총 금액
    private final LocalDateTime date; // 날짜

    @Value
    public class OrderSeq {
        private Long value;
    }
}
