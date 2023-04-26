package com.gongbu.ecommerce.board.adapter.in.web;


import com.gongbu.ecommerce.board.application.port.in.BoardUseCase;
import com.gongbu.ecommerce.board.domain.Board;
import com.gongbu.ecommerce.member.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BoardControllerTest {
    @InjectMocks
    BoardController boardController;
    @Mock
    BoardUseCase boardUseCase;

    @DisplayName("게시판 쓰기 테스트")
    @Test
    public void insertBoard() {
        BoardRequest boardRequest = new BoardRequest();
        boardRequest.setSeq(1L);
        boardRequest.setLike(100L);
        boardRequest.setContext("test");

        when(boardUseCase.insertBoard(boardRequest, 2L)).thenReturn(1L);

        Long seq = boardController.insertBoard(boardRequest, 2L);

        assertThat(seq, is(equalTo(1L)));
    }

    @DisplayName("게시판 타입 변경 테스트")
    @Test
    public void toggleBoardTest() {
        when(boardUseCase.toggleType(1L)).thenReturn("admin");
        String type = boardController.toggleBoard(1L);
        assertThat(type, is(equalTo("admin")));
    }

    @DisplayName("게시판 불러오기 테스트")
    @Test
    public void getBoardTest() {
        Board board = Board.builder()
                .seq(new Board.BoardSeq(1L))
                .memberSeq(new Member.MemberSeq(2L))
                .context("test")
                .heart(100L)
                .build();

        when(boardUseCase.getBoard(1L)).thenReturn(board);
        Board findBoard = boardController.getBoard(1L);

        assertThat(findBoard.getSeq().getValue(), is(1L));
        assertThat(findBoard.getContext(), is("test"));
        assertThat(findBoard.getHeart(), is(100L));
    }

    @DisplayName("좋아요 테스트")
    @Test
    public void addHeartTest() {
        when(boardUseCase.addHeart(1L)).thenReturn(100L);

        Long heart = boardController.addHeart(1L);
        assertThat(heart, is(equalTo(100L)));
    }

    @DisplayName("댓글 테스트")
    @Test
    public void insertCommentTest() {
        when(boardUseCase.insertComment(1L , "test")).thenReturn(3L);
        Long commentSeq = boardController.insertComment(1L, "test");
        assertThat(commentSeq, is(equalTo(3L)));
    }
}
