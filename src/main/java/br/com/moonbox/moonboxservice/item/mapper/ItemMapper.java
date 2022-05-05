package br.com.moonbox.moonboxservice.item.mapper;

import br.com.moonbox.moonboxservice.item.repository.Item;

public class ItemMapper {
    public static Item create(Integer id) {
        return Item.builder()

                .build();
    }
}
