package com.gongbu.ecommerce.board.application.port.in;

import com.gongbu.ecommerce.board.adapter.in.web.BoardRequest;
import com.gongbu.ecommerce.board.domain.Board;

public interface BoardUseCase {
    Long insertBoard(BoardRequest boardRequest, Long memberSeq);

    String toggleType(Long boardSeq);

    Board getBoard(Long boardSeq);

    Long insertComment(Long boardSeq, String comment);

    Long addHeart(Long boardSeq);
}
