package de.aittr.team24_FP_backend.services;

import de.aittr.team24_FP_backend.domain.MainUser_login;
import de.aittr.team24_FP_backend.repositories.User_loginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final User_loginRepository userLoginRepository;

    public MainUser_login saveUser(MainUser_login newUser) {

        if (userLoginRepository.existsByEmail(newUser.getEmail())) {
            Objects.requireNonNull(HttpStatus.CONFLICT, "User with email < " + newUser.getEmail() + " > already exist");
        }

        MainUser_login user = MainUser_login.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                //TODO подумать как прикрутить роль
                .build();

        return userLoginRepository.save(user);
    }
}
