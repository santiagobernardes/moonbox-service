package br.com.moonbox.moonboxservice.box.service;

import br.com.moonbox.moonboxservice.box.repository.Box;
import br.com.moonbox.moonboxservice.box.repository.BoxRepository;
import br.com.moonbox.moonboxservice.util.exception.GenericException;
import br.com.moonbox.moonboxservice.util.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class BoxService {

    private final BoxRepository boxRepository;

    public void save(Box box) {
        boxRepository.save(box);
    }

    public List<Box> findAll() {
        return boxRepository.findAll();
    }

    public Box findById(Integer id) {
        return Optional.ofNullable(boxRepository.findById(id))
                .orElseThrow(() -> new NotFoundException("Box not found"));
    }
}
