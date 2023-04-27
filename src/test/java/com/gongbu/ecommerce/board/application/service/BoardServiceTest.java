package com.gongbu.ecommerce.board.application.service;

import com.gongbu.ecommerce.board.adapter.in.web.BoardRequest;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardMapper;
import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
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
}
