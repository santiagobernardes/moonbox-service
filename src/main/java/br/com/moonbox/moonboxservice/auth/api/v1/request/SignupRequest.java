package br.com.moonbox.moonboxservice.auth.api.v1.request;

import br.com.moonbox.moonboxservice.auth.model.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotNull
    private LocalDate birthDate;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private RoleEnum role;
}
