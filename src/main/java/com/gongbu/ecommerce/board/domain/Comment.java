package com.gongbu.ecommerce.board.domain;

import com.gongbu.ecommerce.member.domain.Member;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
public class Comment {
    private final CommentSeq seq; // PK
    @NonNull private final Member.MemberSeq memberSeq; // 회원 PK
    @NonNull private final Board.BoardSeq boardSeq; // 게시판 PK
    private final String context; // 댓글

    @Value
    public static class CommentSeq {
        private Long value;
    }
}
