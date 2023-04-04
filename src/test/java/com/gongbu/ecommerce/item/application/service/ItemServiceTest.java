package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.adapter.out.persistence.*;
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
    CategoryRepositoryAdapter categoryRepositoryAdapter;
    @Mock
    ItemRepositoryAdapter itemRepositoryAdapter;

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

        when(categoryRepositoryAdapter.getLowerCategoryJpaEntity(1L)).thenReturn(lowerCategoryJpaEntity);


        LowerCategoryJpaEntity findLowerCategoryJpaEntity = categoryRepositoryAdapter.getLowerCategoryJpaEntity(1L);
        ItemJpaEntity itemJpaEntity = itemRequest.mapToJpaEntity(findLowerCategoryJpaEntity);

        when(itemRepositoryAdapter.addItem(itemJpaEntity)).thenReturn(itemJpaEntity.getSeq());
        Long seq = itemRepositoryAdapter.addItem(itemJpaEntity);

        assertThat(seq, is(equalTo(1L)));
    }
}
