package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.domain.Board;
import com.gongbu.ecommerce.board.domain.BoardType;
import com.gongbu.ecommerce.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class BoardMapper {
    public Board mapToEntity(BoardJpaEntity boardJpaEntity) {
        BoardType boardType;
        if ("open".equalsIgnoreCase(boardJpaEntity.getType())) {
            boardType = BoardType.open;
        } else {
            boardType = BoardType.secret;
        }

        Board board = Board.builder()
                .seq(new Board.BoardSeq(boardJpaEntity.getSeq()))
                .title(boardJpaEntity.getTitle())
                .context(boardJpaEntity.getContext())
                .type(boardType)
                .like(boardJpaEntity.getLike())
                .watching(boardJpaEntity.getWatching())
                .memberSeq(new Member.MemberSeq(boardJpaEntity.getMemberJpaEntity().getSeq()))
                .build();
        return board;
    }
}
