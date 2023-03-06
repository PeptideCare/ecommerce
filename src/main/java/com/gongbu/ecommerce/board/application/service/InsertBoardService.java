package com.gongbu.ecommerce.board.application.service;

import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardMapper;
import com.gongbu.ecommerce.board.application.port.in.InsertBoardUseCase;
import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import com.gongbu.ecommerce.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class InsertBoardService implements InsertBoardUseCase {
    private final BoardPort boardPort;
    private final BoardMapper boardMapper;

    @Override
    public void insertBoard() {

    }

    @Override
    public void toggleType(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        findBoardJpaEntity.toggleType();
    }

    @Override
    public Board getBoard(Long boardSeq) {
        return boardMapper.mapToEntity(boardPort.getBoardJpaEntity(boardSeq));
    }

    @Override
    public void insertComment() {

    }

    @Override
    public void addHeart(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        findBoardJpaEntity.addHeart();
    }
}
