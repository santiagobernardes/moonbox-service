package br.com.moonbox.moonboxservice.auth.dto;

import br.com.moonbox.moonboxservice.auth.model.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private RoleEnum role;
    private String accessToken;
    private String tokenType;
    private Integer userId;
}
