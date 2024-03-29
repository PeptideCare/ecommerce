package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.item.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ItemRepositoryAdapter implements ItemPort {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    @Override
    public Long addItem(ItemJpaEntity itemJpaEntity) {
        ItemJpaEntity savedItemJpaEntity = itemRepository.save(itemJpaEntity);
        return savedItemJpaEntity.getSeq();
    }

    @Override
    public Item loadItem(Long itemSeq) {
        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemSeq).
                orElseThrow(EntityNotFoundException::new);
        return itemMapper.mapToEntity(itemJpaEntity);
    }

    @Override
    public ItemJpaEntity loadItemJpaEntity(Long itemSeq) {
        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemSeq).
                orElseThrow(EntityNotFoundException::new);
        return itemJpaEntity;
    }

    @Override
    public Long removeItem(Long itemSeq) {
        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemSeq).
                orElseThrow(EntityNotFoundException::new);
        itemRepository.delete(itemJpaEntity);
        return itemJpaEntity.getSeq();
    }

    @Override
    public List<Item> loadItemList() {
        List<ItemJpaEntity> findItemJpaEntityList = itemRepository.findAll();

        List<Item> itemList = new ArrayList<>();
        for (ItemJpaEntity itemJpaEntity : findItemJpaEntityList) {
            itemList.add(itemMapper.mapToEntity(itemJpaEntity));
        }

        return itemList;
    }
}
