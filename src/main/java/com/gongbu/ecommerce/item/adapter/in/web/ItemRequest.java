package com.gongbu.ecommerce.item.adapter.in.web;
import org.json.JSONObject;

import com.gongbu.ecommerce.item.adapter.out.persistence.ItemJpaEntity;
import com.gongbu.ecommerce.item.adapter.out.persistence.LowerCategoryJpaEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemRequest {
    private Long itemId; // PK
    private int stock; // 재고수량
    private String name; // 물품 이름
    private Long price; // 가격
    private Long lowerCategorySeq;

    // add 용 mapper
    public ItemJpaEntity mapToJpaEntity(LowerCategoryJpaEntity lowerCategoryJpaEntity) {
        ItemJpaEntity itemJpaEntity = ItemJpaEntity.builder()
                .seq(lowerCategoryJpaEntity.getSeq())
                .stock(stock)
                .name(name)
                .price(price)
                .lowerCategoryJpaEntity(lowerCategoryJpaEntity)
                .build();

        return itemJpaEntity;
    }

    public String toJsonString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("itemId", this.itemId);
        jsonObject.put("stock", this.stock);
        jsonObject.put("name", this.name);
        jsonObject.put("price", this.price);
        jsonObject.put("lowerCategorySeq", this.lowerCategorySeq);
        return jsonObject.toString();
    }
}
