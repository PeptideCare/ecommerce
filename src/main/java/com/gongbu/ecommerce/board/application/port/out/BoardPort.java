package com.gongbu.ecommerce.board.application.port.out;

import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;

public interface BoardPort {
    void insertBoard(BoardJpaEntity boardJpaEntity);
    BoardJpaEntity getBoardJpaEntity(Long boardSeq);
}
