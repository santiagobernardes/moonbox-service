package br.com.moonbox.moonboxservice.customer.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
}
