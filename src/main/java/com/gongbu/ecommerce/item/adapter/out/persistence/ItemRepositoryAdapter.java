package com.gongbu.ecommerce.item.adapter.out.persistence;

import com.gongbu.ecommerce.item.application.port.out.ItemPort;
import com.gongbu.ecommerce.item.domain.Item;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemPort {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    @Override
    public void addItem(ItemJpaEntity itemJpaEntity) {
        itemRepository.save(itemJpaEntity);
    }

    @Override
    public Item loadItem(Long itemId) {
        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).
                orElseThrow(EntityNotFoundException::new);
        return itemMapper.mapToEntity(itemJpaEntity);
    }

    @Override
    public void removeItem(Long itemId) {
        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).
                orElseThrow(EntityNotFoundException::new);
        itemRepository.delete(itemJpaEntity);
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
