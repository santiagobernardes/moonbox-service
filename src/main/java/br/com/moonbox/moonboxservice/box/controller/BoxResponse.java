package br.com.moonbox.moonboxservice.box.controller;

import br.com.moonbox.moonboxservice.item.controller.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoxResponse {
    private Integer id;
    private String name;
    private String description;
    private List<ItemResponse> items;
    private BigDecimal salePrice;
}
