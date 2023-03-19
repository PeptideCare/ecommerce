package com.gongbu.ecommerce.board.application.port.out;

import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.board.adapter.out.persistence.CommentJpaEntity;

public interface BoardPort {
    void insertBoard(BoardJpaEntity boardJpaEntity);
    BoardJpaEntity getBoardJpaEntity(Long boardSeq);
    void insertComment(BoardJpaEntity boardJpaEntity, String comment);
    void addHeart(BoardJpaEntity boardJpaEntity);
    void toggleType(BoardJpaEntity boardJpaEntity);

}
