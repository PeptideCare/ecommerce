package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.adapter.out.persistence.*;
import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @Mock
    ItemPort itemPort;
    @Mock
    CategoryPort categoryPort;

    @InjectMocks
    ItemService itemService;

    @Test
    public void addItemTest() {
        List<ItemJpaEntity> itemJpaEntityList = new ArrayList<>();
        itemJpaEntityList.add(new ItemJpaEntity());
        LowerCategoryJpaEntity lowerCategoryJpaEntity = LowerCategoryJpaEntity.builder()
                .seq(1L)
                .name("top")
                .itemJpaEntityList(itemJpaEntityList)
                .upperCategoryJpaEntity(new UpperCategoryJpaEntity())
                .build();
        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setLowerCategorySeq(1L);
        itemRequest.setItemId(2L);
        itemRequest.setName("v-neck");
        itemRequest.setStock(10);
        itemRequest.setPrice(10000L);
        ItemJpaEntity itemJpaEntity = itemRequest.mapToJpaEntity(lowerCategoryJpaEntity);

        when(categoryPort.getLowerCategoryJpaEntity(1L)).thenReturn(lowerCategoryJpaEntity);
        when(itemPort.addItem(itemJpaEntity)).thenReturn(2L);

        Long seq = itemService.addItem(itemRequest);
        assertThat(seq, is(equalTo(2L)));
    }
}
