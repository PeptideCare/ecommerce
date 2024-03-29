package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardJpaEntity {
    @Id
    @GeneratedValue
    private Long seq; // PK
    private String title; // 제목
    private String context; // 본문
    private String type; // 공개 여부 (open, secret)
    private Long heart; // 좋아요
    private Long watching; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberSeq")
    private MemberJpaEntity memberJpaEntity;

    @OneToMany(mappedBy = "boardJpaEntity")
    private List<CommentJpaEntity> commentJpaEntityList;

    public String toggleType() {
        return this.type = "open".equalsIgnoreCase(this.type) ? "secret" : "open";
    }

    public Long addHeart() {
        return this.heart += 1;
    }

    public Long insertComment(CommentJpaEntity commentJpaEntity) {
        this.commentJpaEntityList.add(commentJpaEntity);
        return commentJpaEntity.getSeq();
    }
}
