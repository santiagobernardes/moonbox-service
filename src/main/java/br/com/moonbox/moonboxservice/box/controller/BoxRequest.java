package br.com.moonbox.moonboxservice.box.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoxRequest {
    private String name;
    @NotNull
    private String description;
    private List<Integer> items;
    @NotNull
    private BigDecimal salePrice;
}
