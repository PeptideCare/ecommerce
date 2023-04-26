package com.gongbu.ecommerce.board.application.port.out;

import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.board.adapter.out.persistence.CommentJpaEntity;

public interface BoardPort {
    Long insertBoard(BoardJpaEntity boardJpaEntity);
    BoardJpaEntity getBoardJpaEntity(Long boardSeq);
    Long insertComment(BoardJpaEntity boardJpaEntity, String comment);
    Long addHeart(BoardJpaEntity boardJpaEntity);
    String toggleType(BoardJpaEntity boardJpaEntity);

}
