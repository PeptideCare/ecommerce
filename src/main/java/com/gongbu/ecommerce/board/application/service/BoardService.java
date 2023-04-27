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

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService implements BoardUseCase {
    private final BoardPort boardPort;
    private final AccessMemberPort accessMemberPort;
    private final BoardMapper boardMapper;

    // 게시판 insert
    @Override
    public Long insertBoard(BoardRequest boardRequest, Long memberSeq) {
        MemberJpaEntity findMemberJpaEntity = accessMemberPort.loadMemberJpaEntity(memberSeq);
        BoardJpaEntity boardJpaEntity = boardRequest.mapToJpaEntity(findMemberJpaEntity);
        return boardPort.insertBoard(boardJpaEntity);
    }

    // 게시판 타입 변경
    @Override
    public String toggleType(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        return boardPort.toggleType(findBoardJpaEntity);
    }

    // 게시판 불러오기
    @Override
    public Board getBoard(Long boardSeq) {
        return boardMapper.mapToEntity(boardPort.getBoardJpaEntity(boardSeq));
    }

    // 댓글 쓰기
    @Override
    public Long insertComment(Long boardSeq, String comment) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        return boardPort.insertComment(findBoardJpaEntity, comment);
    }

    // 좋아요
    @Override
    public Long addHeart(Long boardSeq) {
        BoardJpaEntity findBoardJpaEntity = boardPort.getBoardJpaEntity(boardSeq);
        return boardPort.addHeart(findBoardJpaEntity);
    }
}
