package com.gongbu.ecommerce.board.application.port.in;

import com.gongbu.ecommerce.board.adapter.in.web.BoardRequest;
import com.gongbu.ecommerce.board.domain.Board;

public interface BoardUseCase {
    void insertBoard(BoardRequest boardRequest, Long memberSeq);

    void toggleType(Long boardSeq);

    Board getBoard(Long boardSeq);

    void insertComment();

    void addHeart(Long boardSeq);
}
