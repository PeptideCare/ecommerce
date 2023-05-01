package com.gongbu.ecommerce.board.application.service;

import com.gongbu.ecommerce.board.adapter.in.web.BoardRequest;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardMapper;
import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import com.gongbu.ecommerce.board.domain.Board;
import com.gongbu.ecommerce.board.domain.Comment;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
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
public class BoardServiceTest {
    @InjectMocks
    BoardService boardService;
    @Mock
    BoardPort boardPort;
    @Mock
    AccessMemberPort accessMemberPort;
    @Mock
    BoardMapper boardMapper;

    @Test
    @DisplayName("게시판 insert 테스트")
    public void insertBoardTest() {
        BoardRequest boardRequest = new BoardRequest();
        boardRequest.setSeq(1L);
        boardRequest.setLike(100L);
        boardRequest.setContext("contextTest");
        boardRequest.setType("open");
        boardRequest.setTitle("titleTest");

        MemberJpaEntity memberJpaEntity = new MemberJpaEntity();
        memberJpaEntity.setSeq(2L);

        when(accessMemberPort.loadMemberJpaEntity(2L)).thenReturn(memberJpaEntity);
        MemberJpaEntity findMemberJpaEntity = accessMemberPort.loadMemberJpaEntity(2L);
        BoardJpaEntity boardJpaEntity = boardRequest.mapToJpaEntity(findMemberJpaEntity);
        when(boardPort.insertBoard(boardJpaEntity)).thenReturn(1L);

        Long seq = boardService.insertBoard(boardRequest, 2L);

        assertThat(seq, is(equalTo(1L)));
    }

    @Test
    @DisplayName("게시판 타입 변경 테스트")
    public void toggleTypeTest() {
        BoardJpaEntity boardJpaEntity = new BoardJpaEntity();
        boardJpaEntity.setSeq(1L);
        boardJpaEntity.setType("open");

        when(boardPort.getBoardJpaEntity(1L)).thenReturn(boardJpaEntity);
        when(boardPort.toggleType(boardJpaEntity)).thenReturn("secret");

        String type = boardService.toggleType(1L);

        assertThat(type, is(equalTo("secret")));
    }

    @Test
    @DisplayName("게시판 불러오기 테스트")
    public void getBoardTest() {
        Board board = Board.builder()
                .seq(new Board.BoardSeq(1L))
                .title("testTitle")
                .context("testContext")
                .memberSeq(new Member.MemberSeq(2L))
                .build();

        BoardJpaEntity boardJpaEntity = new BoardJpaEntity();
        boardJpaEntity.setSeq(2L);

        when(boardPort.getBoardJpaEntity(2L)).thenReturn(boardJpaEntity);
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(2L);
        when(boardMapper.mapToEntity(findBoardJpaEntity)).thenReturn(board);
        Board findBoard = boardMapper.mapToEntity(findBoardJpaEntity);

        assertThat(findBoard.getSeq().getValue(), is(equalTo(1L)));
        assertThat(findBoard.getTitle(), is(equalTo("testTitle")));
        assertThat(findBoard.getContext(), is(equalTo("testContext")));
    }

    @Test
    @DisplayName("댓글 쓰기 테스트")
    public void insertCommentTest() {
        BoardJpaEntity boardJpaEntity = new BoardJpaEntity();
        boardJpaEntity.setSeq(1L);

        Comment comment = Comment.builder()
                .seq(new Comment.CommentSeq(2L))
                .boardSeq(new Board.BoardSeq(1L))
                .memberSeq(new Member.MemberSeq(3L))
                .context("test")
                .build();


        when(boardPort.getBoardJpaEntity(1L)).thenReturn(boardJpaEntity);
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(1L);

        when(boardPort.insertComment(findBoardJpaEntity, comment.getContext())).thenReturn(comment.getSeq().getValue());
        Long seq = boardPort.insertComment(boardJpaEntity, comment.getContext());

        assertThat(seq, is(equalTo(2L)));
    }

    @Test
    @DisplayName("좋아요 테스트")
    public void addHeartTest() {
        BoardJpaEntity boardJpaEntity = new BoardJpaEntity();
        boardJpaEntity.setSeq(1L);
        boardJpaEntity.setHeart(100L);

        when(boardPort.getBoardJpaEntity(1L)).thenReturn(boardJpaEntity);
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(1L);
        when(boardPort.addHeart(findBoardJpaEntity)).thenReturn(101L);
        Long heart = boardPort.addHeart(findBoardJpaEntity);

        assertThat(heart, is(equalTo(101L)));
    }
}
