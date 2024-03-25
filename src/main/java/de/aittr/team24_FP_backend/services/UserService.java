package de.aittr.team24_FP_backend.services;

import de.aittr.team24_FP_backend.domain.User_login;
import de.aittr.team24_FP_backend.repositories.User_loginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final User_loginRepository userLoginRepository;

    public User_login saveUser(User_login newUser) {

        if (userLoginRepository.existsByEmail(newUser.getEmail())) {
            Objects.requireNonNull(HttpStatus.CONFLICT, "User with email < " + newUser.getEmail() + " > already exist");
        }

        User_login user = User_login.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                //TODO подумать как прикрутить роль
                .build();

        return userLoginRepository.save(user);
    }
}
