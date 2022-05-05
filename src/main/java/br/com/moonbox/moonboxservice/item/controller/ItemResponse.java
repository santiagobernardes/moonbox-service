package br.com.moonbox.moonboxservice.item.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal salePrice;
}
