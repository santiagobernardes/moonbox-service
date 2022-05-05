package br.com.moonbox.moonboxservice.auth.service;

import br.com.moonbox.moonboxservice.auth.model.User;
import br.com.moonbox.moonboxservice.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email).equals(1);
    }
}
