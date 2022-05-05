package br.com.moonbox.moonboxservice.auth.service;

import br.com.moonbox.moonboxservice.auth.dto.AuthDto;
import br.com.moonbox.moonboxservice.auth.jwt.JwtHelper;
import br.com.moonbox.moonboxservice.auth.model.RoleEnum;
import br.com.moonbox.moonboxservice.auth.model.User;
import br.com.moonbox.moonboxservice.util.exception.GenericException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthService {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private JwtHelper jwtHelper;

    public void signup(AuthDto authDto) {
        if (userService.existsByEmail(authDto.getEmail())) {
            throw new GenericException("Email already registered");
        }

        User user = User.builder()
                .email(authDto.getEmail())
                .password(passwordEncoder.encode(authDto.getPassword()))
                .firstName(authDto.getFirstName())
                .lastName(authDto.getLastName())
                .birthDate(authDto.getBirthDate())
                .role(Optional.ofNullable(authDto.getRole()).orElse(RoleEnum.USER))
                .build();

        userService.save(user);
    }

    public AuthDto signin(AuthDto authDto) {
        authDto.setUsername(authDto.getEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtHelper.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return AuthDto.builder()
                .accessToken(jwt)
                .email(userDetails.getUsername())
                .userId(userDetails.getId())
                .build();
    }
}
