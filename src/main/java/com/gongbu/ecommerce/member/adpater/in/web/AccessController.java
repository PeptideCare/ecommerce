package com.gongbu.ecommerce.member.adpater.in.web;

import com.gongbu.ecommerce.member.application.port.in.AccessUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccessController {
    private final AccessUseCase accessUseCase;


}
