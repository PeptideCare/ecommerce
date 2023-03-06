package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
public class BoardRepositoryAdapter implements BoardPort {
    private final BoardRepository boardRepository;

    public void insertBoard(BoardJpaEntity boardJpaEntity) {
        boardRepository.save(boardJpaEntity);
    }

    public BoardJpaEntity getBoardJpaEntity(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardRepository.findById(boardSeq).
                orElseThrow(EntityNotFoundException::new);
        return findBoardJpaEntity;
    }
}
