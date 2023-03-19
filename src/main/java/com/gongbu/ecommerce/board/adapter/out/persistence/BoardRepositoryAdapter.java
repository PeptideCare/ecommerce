package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RequiredArgsConstructor
public class BoardRepositoryAdapter implements BoardPort {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public void insertBoard(BoardJpaEntity boardJpaEntity) {
        boardRepository.save(boardJpaEntity);
    }

    public BoardJpaEntity getBoardJpaEntity(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardRepository.findById(boardSeq).
                orElseThrow(EntityNotFoundException::new);
        return findBoardJpaEntity;
    }
    public void insertComment(BoardJpaEntity boardJpaEntity, String comment) {
        CommentJpaEntity commentJpaEntity = CommentJpaEntity.builder()
                        .comment(comment)
                        .boardJpaEntity(boardJpaEntity)
                        .memberJpaEntity(boardJpaEntity.getMemberJpaEntity())
                        .build();
        boardJpaEntity.insertComment(commentJpaEntity);
    }
    public void addHeart(BoardJpaEntity boardJpaEntity) {
        boardJpaEntity.addHeart();
    }
    public void toggleType(BoardJpaEntity boardJpaEntity) {
        boardJpaEntity.toggleType();
    }
}
