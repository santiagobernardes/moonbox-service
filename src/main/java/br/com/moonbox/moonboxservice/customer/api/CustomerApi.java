package br.com.moonbox.moonboxservice.customer.api;

import br.com.moonbox.moonboxservice.customer.repository.Customer;
import br.com.moonbox.moonboxservice.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerApi {

    private final ObjectMapper objectMapper;
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid CustomerRequest customerRequest) {
        Customer customer = objectMapper.convertValue(customerRequest, Customer.class);
        customerService.save(customer);
    }

    @GetMapping
    public List<CustomerResponse> findAll() {
        return customerService.findAll()
                .stream()
                .map(customer -> objectMapper.convertValue(customer, CustomerResponse.class))
                .collect(Collectors.toList());
    }

}
