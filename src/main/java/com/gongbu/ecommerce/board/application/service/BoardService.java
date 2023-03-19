package com.gongbu.ecommerce.board.application.service;

import com.gongbu.ecommerce.board.adapter.in.web.BoardRequest;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardJpaEntity;
import com.gongbu.ecommerce.board.adapter.out.persistence.BoardMapper;
import com.gongbu.ecommerce.board.application.port.in.BoardUseCase;
import com.gongbu.ecommerce.board.application.port.out.BoardPort;
import com.gongbu.ecommerce.board.domain.Board;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService implements BoardUseCase {
    private final BoardPort boardPort;
    private final AccessMemberPort accessMemberPort;
    private final BoardMapper boardMapper;

    @Override
    public void insertBoard(BoardRequest boardRequest, Long memberSeq) {
        MemberJpaEntity findMemberJpaEntity = accessMemberPort.loadMemberJpaEntity(memberSeq);
        BoardJpaEntity boardJpaEntity = boardRequest.mapToJpaEntity(findMemberJpaEntity);
        boardPort.insertBoard(boardJpaEntity);
    }

    @Override
    public void toggleType(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        boardPort.toggleType(findBoardJpaEntity);
    }

    @Override
    public Board getBoard(Long boardSeq) {
        return boardMapper.mapToEntity(boardPort.getBoardJpaEntity(boardSeq));
    }

    @Override
    public void insertComment(Long boardSeq, String comment) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        boardPort.insertComment(findBoardJpaEntity, comment);
    }

    @Override
    public void addHeart(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        boardPort.addHeart(findBoardJpaEntity);
    }
}
