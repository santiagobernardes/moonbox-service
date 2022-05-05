package br.com.moonbox.moonboxservice.customer.service;

import br.com.moonbox.moonboxservice.customer.repository.Customer;
import br.com.moonbox.moonboxservice.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
