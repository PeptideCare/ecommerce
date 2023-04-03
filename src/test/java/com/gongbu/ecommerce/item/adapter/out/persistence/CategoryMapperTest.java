package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.LowerCategoryType;
import com.gongbu.ecommerce.item.domain.UpperCategory;
import com.gongbu.ecommerce.item.domain.UpperCategoryType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class CategoryMapperTest {
    @Test
    @DisplayName("LowerCategory Domain 매핑 테스트")
    public void mapToLowerCategoryEntityTest() {
        UpperCategoryJpaEntity upperCategoryJpaEntity = new UpperCategoryJpaEntity();
        upperCategoryJpaEntity.setSeq(1L);

        LowerCategoryJpaEntity lowerCategoryJpaEntity = new LowerCategoryJpaEntity();
        lowerCategoryJpaEntity.setSeq(1L);
        lowerCategoryJpaEntity.setName("top");
        lowerCategoryJpaEntity.setUpperCategoryJpaEntity(upperCategoryJpaEntity);

        LowerCategory lowerCategory = LowerCategory.builder()
                .seq(new LowerCategory.LowerCategorySeq(lowerCategoryJpaEntity.getSeq()))
                .name(LowerCategoryType.valueOf(lowerCategoryJpaEntity.getName()))
                .upperCategorySeq(new UpperCategory.UpperCategorySeq(lowerCategoryJpaEntity.getUpperCategoryJpaEntity().getSeq()))
                .build();

        assertThat(lowerCategory.getSeq().getValue(), is(equalTo(lowerCategoryJpaEntity.getSeq())));
        assertThat(lowerCategory.getName().name(), is(equalTo(lowerCategoryJpaEntity.getName())));
        assertThat(lowerCategory.getUpperCategorySeq().getValue(), is(equalTo(lowerCategoryJpaEntity.getUpperCategoryJpaEntity().getSeq())));
    }

    @Test
    @DisplayName("UpperCategory Domain 매핑 테스트")
    public void mapToUpperCategoryEntityTest() {
        LowerCategoryJpaEntity lowerCategoryJpaEntity = new LowerCategoryJpaEntity();
        lowerCategoryJpaEntity.setSeq(1L);
        List<LowerCategoryJpaEntity> lowerCategoryJpaEntityList = new ArrayList<>();
        lowerCategoryJpaEntityList.add(lowerCategoryJpaEntity);

        UpperCategoryJpaEntity upperCategoryJpaEntity = new UpperCategoryJpaEntity();
        upperCategoryJpaEntity.setSeq(1L);
        upperCategoryJpaEntity.setName("clothes");
        upperCategoryJpaEntity.setLowerCategoryJpaEntityList(lowerCategoryJpaEntityList);

        UpperCategory upperCategory = UpperCategory.builder()
                .seq(new UpperCategory.UpperCategorySeq(upperCategoryJpaEntity.getSeq()))
                .name(UpperCategoryType.valueOf(upperCategoryJpaEntity.getName()))
                .build();

        assertThat(upperCategory.getSeq().getValue(), is(equalTo(upperCategoryJpaEntity.getSeq())));
        assertThat(upperCategory.getName().name(), is(equalTo(upperCategoryJpaEntity.getName())));
    }
}
