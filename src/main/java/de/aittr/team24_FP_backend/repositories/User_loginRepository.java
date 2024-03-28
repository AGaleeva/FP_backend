package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.MainUser_login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_loginRepository extends JpaRepository<MainUser_login, Integer> {

    boolean existsByEmail(String email);

}
