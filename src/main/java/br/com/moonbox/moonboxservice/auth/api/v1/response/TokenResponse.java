package br.com.moonbox.moonboxservice.auth.api.v1.response;

import br.com.moonbox.moonboxservice.auth.model.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String email;
    private RoleEnum role;
    private String accessToken;
    private Integer expirationInMinutes;
}
