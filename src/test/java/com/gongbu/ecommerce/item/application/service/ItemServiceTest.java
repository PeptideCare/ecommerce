package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.adapter.in.web.ItemRequest;
import com.gongbu.ecommerce.item.adapter.out.persistence.*;
import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("물품 추가 테스트")
    public void addItemTest() {
        List<ItemJpaEntity> itemJpaEntityList = new ArrayList<>();
        itemJpaEntityList.add(new ItemJpaEntity());
        LowerCategoryJpaEntity lowerCategoryJpaEntity = LowerCategoryJpaEntity.builder()
                .seq(1L)
                .name("top")
                .itemJpaEntityList(itemJpaEntityList)
                .upperCategoryJpaEntity(new UpperCategoryJpaEntity())
                .build();
        ItemRequest itemRequest = ItemRequest.builder()
                .itemId(2L)
                .stock(10)
                .price(10000L)
                .name("v-neck")
                .lowerCategorySeq(1L)
                .build();
        ItemJpaEntity itemJpaEntity = itemRequest.mapToJpaEntity(lowerCategoryJpaEntity);

        when(categoryPort.getLowerCategoryJpaEntity(1L)).thenReturn(lowerCategoryJpaEntity);
        when(itemPort.addItem(itemJpaEntity)).thenReturn(2L);

        Long seq = itemService.addItem(itemRequest);
        assertThat(seq, is(equalTo(2L)));
    }

    @Test
    @DisplayName("물품 삭제 테스트")
    public void removeItemTest() {
        Long itemSeq = 1L;
        when(itemPort.removeItem(itemSeq)).thenReturn(1L);

        Long seq = itemService.removeItem(itemSeq);
        assertThat(seq, is(equalTo(1L)));
    }

    @Test
    @DisplayName("물품 가져오기 테스트")
    public void getItemTest() {
        Long itemSeq = 1L;

        Item item = Item.builder()
                .seq(new Item.ItemSeq(1L))
                .stock(100)
                .lowerCategorySeq(new LowerCategory.LowerCategorySeq(2L))
                .price(10000L)
                .name("v-neck")
                .build();

        when(itemPort.loadItem(itemSeq)).thenReturn(item);

        Item findItem = itemService.getItem(itemSeq);
        assertThat(findItem.getSeq().getValue(), is(equalTo(1L)));
        assertThat(findItem.getLowerCategorySeq().getValue(), is(equalTo(2L)));
        assertThat(findItem.getStock(), is(equalTo(100)));
        assertThat(findItem.getPrice(), is(equalTo(10000L)));
        assertThat(findItem.getName(), is(equalTo("v-neck")));
    }
}
