package br.com.moonbox.moonboxservice.item.service;

import br.com.moonbox.moonboxservice.item.repository.Item;
import br.com.moonbox.moonboxservice.item.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item save(Item item) {
        return null;
    }

    public List<Item> findAll() {
        return Collections.emptyList();
    }

    public Item findById(Integer id) {
        return null;
    }
}
