package com.gongbu.ecommerce.board.application.port.in;

import com.gongbu.ecommerce.board.domain.Board;

public interface InsertBoardUseCase {
    void insertBoard();

    void toggleType(Long boardSeq);

    Board getBoard(Long boardSeq);

    void insertComment();

    void addHeart(Long boardSeq);
}
