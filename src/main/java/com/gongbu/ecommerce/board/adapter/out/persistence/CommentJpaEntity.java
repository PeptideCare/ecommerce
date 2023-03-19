package com.gongbu.ecommerce.board.adapter.out.persistence;

import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentJpaEntity {
    @Id
    @GeneratedValue
    private Long seq; // PK

    private String comment; // 댓글

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq")
    private MemberJpaEntity memberJpaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seq")
    private BoardJpaEntity boardJpaEntity;
}
