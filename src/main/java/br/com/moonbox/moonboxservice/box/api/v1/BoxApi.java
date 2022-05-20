package br.com.moonbox.moonboxservice.box.api.v1;

import br.com.moonbox.moonboxservice.box.api.v1.request.BoxRequest;
import br.com.moonbox.moonboxservice.box.api.v1.response.BoxResponse;
import br.com.moonbox.moonboxservice.box.mapper.BoxMapper;
import br.com.moonbox.moonboxservice.box.service.BoxService;
import br.com.moonbox.moonboxservice.box.repository.Box;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/boxes")
public class BoxApi {

    private final ObjectMapper objectMapper;
    private final BoxService boxService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid BoxRequest boxRequest) {
        Box box = BoxMapper.map(boxRequest);
        boxService.save(box);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
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
