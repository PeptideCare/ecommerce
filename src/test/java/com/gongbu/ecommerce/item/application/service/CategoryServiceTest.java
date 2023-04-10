package com.gongbu.ecommerce.item.application.service;

import com.gongbu.ecommerce.item.adapter.out.persistence.CategoryRepositoryAdapter;
import com.gongbu.ecommerce.item.application.port.out.CategoryPort;
import com.gongbu.ecommerce.item.domain.LowerCategory;
import com.gongbu.ecommerce.item.domain.LowerCategoryType;
import com.gongbu.ecommerce.item.domain.UpperCategory;
import com.gongbu.ecommerce.item.domain.UpperCategoryType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    CategoryPort categoryPort;

    @InjectMocks
    CategoryService categoryService;

    @Test
    @DisplayName("getLowerCategory 테스트")
    public void getLowerCategoryTest() {
        LowerCategory lowerCategory = LowerCategory.builder()
                        .seq(new LowerCategory.LowerCategorySeq(1L))
                        .name(LowerCategoryType.valueOf("top"))
                        .upperCategorySeq(new UpperCategory.UpperCategorySeq(1L))
                        .build();

        when(categoryService.getLowerCategory(1L)).thenReturn(lowerCategory);
        LowerCategory findLowerCategory = categoryService.getLowerCategory(lowerCategory.getSeq().getValue());

        assertThat(findLowerCategory.getSeq().getValue(), is(equalTo(1L)));
    }

    @Test
    @DisplayName("getUpperCategory 테스트")
    public void getUpperCategoryTest() {
        UpperCategory upperCategory = UpperCategory.builder()
                        .seq(new UpperCategory.UpperCategorySeq(1L))
                        .name(UpperCategoryType.valueOf("clothes"))
                        .build();

        when(categoryService.getUpperCategory(1L)).thenReturn(upperCategory);
        UpperCategory findUpperCategory = categoryService.getUpperCategory(upperCategory.getSeq().getValue());

        assertThat(findUpperCategory.getSeq().getValue(), is(equalTo(1L)));
    }
}
