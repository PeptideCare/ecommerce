package com.gongbu.ecommerce.member.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PointHistory {
    private final PointHistorySeq seq; // PK
    @NonNull private final Member.MemberSeq memberSeq; // 회원 PK
    private final LocalDateTime date; // 포인트 수정 날짜
    private final Long point; // 포인트 수량
    private final PointType pointType; // 포인트 타입 (get, use)

    @Value
    public class PointHistorySeq {
        private Long value;
    }
}
