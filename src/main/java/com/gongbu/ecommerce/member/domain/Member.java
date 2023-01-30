package com.gongbu.ecommerce.member.domain;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Member {
    private final MemberSeq seq; // PK
    private final String memberId;  // 사용자 ID
    private final String memberPw;  // 사용자 PW
    private final MemberType memberType;  // 관리자와 유저를 구분
    private final Long myPoint;  // 구매 후 받는 포인트

    @Value
    public static class MemberSeq {
        private Long value;
    }


}
