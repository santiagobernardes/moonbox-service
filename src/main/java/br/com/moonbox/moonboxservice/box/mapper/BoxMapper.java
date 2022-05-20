package br.com.moonbox.moonboxservice.box.mapper;

import br.com.moonbox.moonboxservice.box.api.v1.request.BoxRequest;
import br.com.moonbox.moonboxservice.box.repository.Box;

public class BoxMapper {
    public static Box map(BoxRequest boxRequest) {
        return Box.builder()
                .name(boxRequest.getName())
                .description(boxRequest.getDescription())
                .salePrice(boxRequest.getSalePrice())
                .build();
    }
}
