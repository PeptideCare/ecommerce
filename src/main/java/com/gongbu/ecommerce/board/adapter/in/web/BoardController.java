package com.gongbu.ecommerce.board.adapter.in.web;

import com.gongbu.ecommerce.board.application.port.in.BoardUseCase;
import com.gongbu.ecommerce.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardUseCase boardUseCase;

    // 게시판 쓰기
    @PostMapping("/ecommerce/board/add/{memberSeq}")
    public void insertBoard(BoardRequest boardRequest, @PathVariable ("memberSeq") Long memberSeq) {
        boardUseCase.insertBoard(boardRequest, memberSeq);
    }

    // 게시판 타입 변경 (공개, 비공개)
    @GetMapping("/ecommerce/board/toggle/{boardSeq}")
    public void toggleBoard(@PathVariable ("boardSeq") Long boardSeq) {
        boardUseCase.toggleType(boardSeq);
    }

    // 게시판 불러오기
    @ResponseBody
    @GetMapping("/ecommerce/board/get/{boardSeq}")
    public Board getBoard(@PathVariable ("boardSeq") Long boardSeq) {
        Board board = boardUseCase.getBoard(boardSeq);
        return board;
    }

    // 좋아요
    @GetMapping("/ecommerce/board/addHeart/{boardSeq}")
    public void addHeart(@PathVariable ("boardSeq") Long boardSeq) {
        boardUseCase.addHeart(boardSeq);
    }
}
