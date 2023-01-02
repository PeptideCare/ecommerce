package com.gongbu.ecommerce.member.adpater.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJpaEntity {

    @Id
    @GeneratedValue
    private Long seq;

    private String id;
    private String password;
    private String memberType;
    private Long myPoint;
}
