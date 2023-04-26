package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
public class BoardRepositoryAdapter implements BoardPort {
    private final BoardRepository boardRepository;

    public Long insertBoard(BoardJpaEntity boardJpaEntity) {
        BoardJpaEntity savedBoardJpaEntity = boardRepository.save(boardJpaEntity);
        return savedBoardJpaEntity.getSeq();
    }

    public BoardJpaEntity getBoardJpaEntity(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardRepository.findById(boardSeq).
                orElseThrow(EntityNotFoundException::new);
        return findBoardJpaEntity;
    }
    public Long insertComment(BoardJpaEntity boardJpaEntity, String comment) {
        CommentJpaEntity commentJpaEntity = CommentJpaEntity.builder()
                        .comment(comment)
                        .boardJpaEntity(boardJpaEntity)
                        .memberJpaEntity(boardJpaEntity.getMemberJpaEntity())
                        .build();
        return boardJpaEntity.insertComment(commentJpaEntity);
    }
    public Long addHeart(BoardJpaEntity boardJpaEntity) {
        return boardJpaEntity.addHeart();
    }
    public String toggleType(BoardJpaEntity boardJpaEntity) {
        return boardJpaEntity.toggleType();
    }
}
