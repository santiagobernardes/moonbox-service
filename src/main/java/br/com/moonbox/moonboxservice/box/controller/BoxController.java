package br.com.moonbox.moonboxservice.box.controller;

import br.com.moonbox.moonboxservice.box.mapper.BoxMapper;
import br.com.moonbox.moonboxservice.box.service.BoxService;
import br.com.moonbox.moonboxservice.box.repository.Box;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/boxes")
public class BoxController {

    private final ObjectMapper objectMapper;
    private final BoxService boxService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Secured({"ROLE_USER"})
    public void create(@RequestBody @Valid BoxRequest boxRequest) {
        Box box = BoxMapper.map(boxRequest);
        boxService.save(box);
    }

    @GetMapping
    public List<BoxResponse> findAll() {
        return boxService.findAll()
                .stream()
                .map(box -> objectMapper.convertValue(box, BoxResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BoxResponse getById(@PathVariable Integer id) {
        Box box = boxService.findById(id);
        return objectMapper.convertValue(box, BoxResponse.class);
    }
}
