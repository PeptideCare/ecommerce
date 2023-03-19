package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.domain.Board;
import com.gongbu.ecommerce.board.domain.Comment;
import com.gongbu.ecommerce.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment mapToEntity(CommentJpaEntity commentJpaEntity) {
        Comment comment = Comment.builder()
                .seq(new Comment.CommentSeq(commentJpaEntity.getSeq()))
                .boardSeq(new Board.BoardSeq(commentJpaEntity.getBoardJpaEntity().getSeq()))
                .memberSeq(new Member.MemberSeq(commentJpaEntity.getMemberJpaEntity().getSeq()))
                .context(commentJpaEntity.getComment())
                .build();
        return comment;
    }
}
