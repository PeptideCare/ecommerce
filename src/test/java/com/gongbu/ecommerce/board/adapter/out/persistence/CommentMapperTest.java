package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.domain.Comment;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
@ExtendWith(MockitoExtension.class)
public class CommentMapperTest {

    @InjectMocks
    CommentMapper commentMapper;

    @Test
    @DisplayName("엔터티 매핑 테스트")
    public void mapToEntityTest() {
        BoardJpaEntity boardJpaEntity = BoardJpaEntity.builder()
                .seq(3L)
                .build();

        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .seq(4L)
                .build();

        CommentJpaEntity commentJpaEntity = CommentJpaEntity.builder()
                .seq(1L)
                .boardJpaEntity(boardJpaEntity)
                .memberJpaEntity(memberJpaEntity)
                .build();

        Comment comment = commentMapper.mapToEntity(commentJpaEntity);

        assertThat(comment.getSeq().getValue(), is(equalTo(1L)));
        assertThat(comment.getBoardSeq().getValue(), is(equalTo(3L)));
        assertThat(comment.getMemberSeq().getValue(), is(equalTo(4L)));
    }
}
