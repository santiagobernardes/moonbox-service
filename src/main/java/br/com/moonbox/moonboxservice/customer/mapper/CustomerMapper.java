package br.com.moonbox.moonboxservice.customer.mapper;

import br.com.moonbox.moonboxservice.customer.api.CustomerRequest;
import br.com.moonbox.moonboxservice.customer.repository.Customer;

public class CustomerMapper {
    public static Customer map(CustomerRequest customerRequest) {
        return Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .birthDate(customerRequest.getBirthDate())
                .email(customerRequest.getEmail())
                .build();
    }
}
