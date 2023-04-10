package com.gongbu.ecommerce.item.adapter.in.web;

import com.gongbu.ecommerce.item.application.port.in.ItemUseCase;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemControllerTest {

    @Mock
    ItemPort itemPort;

    @Mock
    ItemUseCase itemUseCase;

    @InjectMocks
    ItemController itemController;

    @Test
    @DisplayName("물품추가 테스트")
    public void addItemTest() {
        ItemRequest itemRequest = ItemRequest.builder()
                .itemId(0L)
                .stock(10)
                .name("반팔")
                .price(10000L)
                .lowerCategorySeq(2L)
                .build();

        Long seq = itemController.addItem(itemRequest);

        assertThat(seq, is(equalTo(0L)));
    }

    @Test
    @DisplayName("물품삭제 테스트")
    public void removeItemTest() {
        Long itemId = 1L;
        when(itemUseCase.removeItem(itemId)).thenReturn(itemId);
        Long seq = itemController.removeItem(itemId);
        assertThat(seq, is(equalTo(1L)));
    }

    @Test
    @DisplayName("물품 가져오기 테스트")
    public void getItemTest() {
        Item item = Item.builder()
                .seq(new Item.ItemSeq(1L))
                .lowerCategorySeq(new LowerCategory.LowerCategorySeq(2L))
                .price(10000L)
                .name("v-neck")
                .stock(5)
                .build();
        Long itemSeq = 1L;

        when(itemUseCase.getItem(itemSeq)).thenReturn(item);
        Item findItem = itemController.getItem(itemSeq);
        assertThat(findItem.getSeq().getValue(), is(equalTo(1L)));
        assertThat(findItem.getStock(), is(equalTo(5)));
        assertThat(findItem.getLowerCategorySeq().getValue(), is(equalTo(2L)));
        assertThat(findItem.getPrice(), is(equalTo(10000L)));
        assertThat(findItem.getName(), is(equalTo("v-neck")));
        assertThat(findItem.getStock(), is(equalTo(5)));
    }

    @Test
    @DisplayName("물품 리스트 가져오기 테스트")
    public void getItemListTest() {
        Item item = Item.builder()
                .seq(new Item.ItemSeq(1L))
                .stock(100)
                .lowerCategorySeq(new LowerCategory.LowerCategorySeq(2L))
                .price(10000L)
                .name("v-neck")
                .build();

        Item item1 = Item.builder()
                .seq(new Item.ItemSeq(2L))
                .stock(200)
                .lowerCategorySeq(new LowerCategory.LowerCategorySeq(3L))
                .price(20000L)
                .name("clock")
                .build();

        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item1);

        when(itemUseCase.getItemList()).thenReturn(itemList);
        List<Item> findItemList = itemController.getItemList();

        assertThat(findItemList.get(0).getSeq().getValue(), is(equalTo(1L)));
        assertThat(findItemList.get(1).getSeq().getValue(), is(equalTo(2L)));
    }
}
