package br.com.moonbox.moonboxservice.auth.controller.v1;

import br.com.moonbox.moonboxservice.auth.controller.v1.request.LoginRequest;
import br.com.moonbox.moonboxservice.auth.controller.v1.request.SignupRequest;
import br.com.moonbox.moonboxservice.auth.controller.v1.response.TokenResponse;
import br.com.moonbox.moonboxservice.auth.dto.AuthDto;
import br.com.moonbox.moonboxservice.auth.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private ObjectMapper objectMapper;
    private AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignupRequest signupRequest) {
        AuthDto authDto = objectMapper.convertValue(signupRequest, AuthDto.class);
        authService.signup(authDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        AuthDto authDto = objectMapper.convertValue(loginRequest, AuthDto.class);
        AuthDto signin = authService.signin(authDto);
        return objectMapper.convertValue(signin, TokenResponse.class);
    }
}
