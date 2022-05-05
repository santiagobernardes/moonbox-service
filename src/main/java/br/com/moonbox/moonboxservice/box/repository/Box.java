package br.com.moonbox.moonboxservice.box.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Box {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal salePrice;
}
