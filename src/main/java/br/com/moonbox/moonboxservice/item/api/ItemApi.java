package br.com.moonbox.moonboxservice.item.api;

import br.com.moonbox.moonboxservice.item.service.ItemService;
import br.com.moonbox.moonboxservice.item.repository.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemApi {

    private final ObjectMapper objectMapper;
    private final ItemService itemService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse create(@RequestBody ItemRequest itemRequest) {
        Item item = objectMapper.convertValue(itemRequest, Item.class);
        return objectMapper.convertValue(itemService.save(item), ItemResponse.class);
    }

    @GetMapping
    public List<ItemResponse> getAll() {
        return itemService.findAll()
                .stream()
                .map(item -> objectMapper.convertValue(item, ItemResponse.class))
                .collect(Collectors.toList());
    }
}
