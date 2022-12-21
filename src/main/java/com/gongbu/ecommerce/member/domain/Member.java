package com.gongbu.ecommerce.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Member {
    private final MemberSeq seq; // PK
    private final String id;  // 사용자 ID
    private final String password;  // 사용자 PW
    private final MemberType memberType;  // 관리자와 유저를 구분
    private final String point;  // 구매 후 받는 포인트

    @Value
    public static class MemberSeq {
        private Long value;
    }
}
