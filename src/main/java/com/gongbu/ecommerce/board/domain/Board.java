package com.gongbu.ecommerce.board.domain;

import com.gongbu.ecommerce.member.domain.Member;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Getter
public class Board {
    private final BoardSeq seq; // PK
    @NonNull private Member.MemberSeq memberSeq; // 회원 PK
    private final String title; // 제목
    private final String context; // 본문
    private final BoardType type; // 공개/비공개 타입
    private final Long like; // 좋아요
    private final Long watching; // 조회수

    @Value
    public class BoardSeq {
        private Long value;
    }

}
