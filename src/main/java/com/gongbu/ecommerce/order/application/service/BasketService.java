package com.gongbu.ecommerce.order.application.service;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.member.adpater.out.persistence.MemberJpaEntity;
import com.gongbu.ecommerce.member.application.port.out.AccessMemberPort;
import com.gongbu.ecommerce.order.adapter.in.web.BasketRequest;
import com.gongbu.ecommerce.order.adapter.out.persistence.BasketJpaEntity;
import com.gongbu.ecommerce.order.application.port.in.BasketUseCase;
import com.gongbu.ecommerce.order.application.port.out.BasketPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService implements BasketUseCase {
    private final BasketPort basketPort;
    private final AccessMemberPort accessMemberPort;
    private final ItemPort itemPort;

    @Override
    public void addBasket(BasketRequest basketRequest) {
        MemberJpaEntity findMemberJpaEntity = accessMemberPort.loadMemberJpaEntity(basketRequest.getMemberSeq());
        ItemJpaEntity findItemJpaEntity = itemPort.loadItemJpaEntity(basketRequest.getItemSeq());
        BasketJpaEntity basketJpaEntity = basketRequest.mapToJpaEntity(findMemberJpaEntity, findItemJpaEntity);

        basketPort.addBasket(basketJpaEntity);
        System.out.println("adding order in basket success");
    }
}
