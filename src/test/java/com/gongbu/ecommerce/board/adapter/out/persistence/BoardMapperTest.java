package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.domain.Board;
import com.gongbu.ecommerce.board.domain.BoardType;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BoardMapperTest {

    @InjectMocks
    BoardMapper boardMapper;

    @Test
    @DisplayName("엔터티 매핑 테스트")
    public void mapToEntityTest() {
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .seq(2L)
                .build();


        BoardJpaEntity boardJpaEntity = BoardJpaEntity.builder()
                .seq(1L)
                .memberJpaEntity(memberJpaEntity)
                .title("titleTest")
                .context("contextTest")
                .type("open")
                .heart(100L)
                .watching(12000000L)
                .build();

        Board board = boardMapper.mapToEntity(boardJpaEntity);

        assertThat(board.getSeq().getValue(), is(equalTo(1L)));
        assertThat(board.getTitle(), is(equalTo("titleTest")));
        assertThat(board.getContext(), is(equalTo("contextTest")));
        assertThat(board.getType(), is(equalTo(BoardType.open)));
        assertThat(board.getHeart(), is(equalTo(100L)));
        assertThat(board.getWatching(), is(equalTo(12000000L)));
        assertThat(board.getMemberSeq().getValue(), is(equalTo(2L)));
    }
}
