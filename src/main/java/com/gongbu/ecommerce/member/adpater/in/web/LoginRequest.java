package com.gongbu.ecommerce.member.adpater.in.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String memberId;
    private String memberPw;
}
