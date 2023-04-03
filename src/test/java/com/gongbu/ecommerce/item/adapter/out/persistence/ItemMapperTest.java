package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.Item;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class ItemMapperTest {

    @Test
    @DisplayName("Item Domain 매핑 테스트")
    public void mapToEntityTest() {
        LowerCategoryJpaEntity lowerCategoryJpaEntity = new LowerCategoryJpaEntity();
        lowerCategoryJpaEntity.setSeq(1L);

        ItemJpaEntity itemJpaEntity = new ItemJpaEntity();
        itemJpaEntity.setSeq(1L);
        itemJpaEntity.setStock(1);
        itemJpaEntity.setName("test");
        itemJpaEntity.setRating(2);
        itemJpaEntity.setPrice(12000L);
        itemJpaEntity.setLowerCategoryJpaEntity(lowerCategoryJpaEntity);

        Item item = Item.builder()
                .seq(new Item.ItemSeq(itemJpaEntity.getSeq()))
                .stock(itemJpaEntity.getStock())
                .name(itemJpaEntity.getName())
                .rating(itemJpaEntity.getRating())
                .price(itemJpaEntity.getPrice())
                .lowerCategorySeq(new LowerCategory.LowerCategorySeq(itemJpaEntity.getLowerCategoryJpaEntity().getSeq()))
                .build();

        assertThat(itemJpaEntity.getSeq(), is(equalTo(item.getSeq().getValue())));
        assertThat(itemJpaEntity.getStock(), is(equalTo(item.getStock())));
        assertThat(itemJpaEntity.getName(), is(equalTo(item.getName())));
        assertThat(itemJpaEntity.getRating(), is(equalTo(item.getRating())));
        assertThat(itemJpaEntity.getPrice(), is(equalTo(item.getPrice())));
        assertThat(itemJpaEntity.getLowerCategoryJpaEntity().getSeq(), is(equalTo(item.getLowerCategorySeq().getValue())));
    }
}
