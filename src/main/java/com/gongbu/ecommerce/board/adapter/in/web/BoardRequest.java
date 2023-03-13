package com.gongbu.ecommerce.board.adapter.in.web;

import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.Data;

@Data
public class BoardRequest {
    private Long seq;
    private String title;
    private String context;
    private String type;
    private Long like;
    private long watching;

    public BoardJpaEntity mapToJpaEntity(MemberJpaEntity memberJpaEntity) {
        BoardJpaEntity boardJpaEntity = BoardJpaEntity.builder()
                .title(this.title)
                .context(this.context)
                .type(this.type)
                .like(like)
                .watching(watching)
                .memberJpaEntity(memberJpaEntity)
                .build();
        return boardJpaEntity;
    }
}
