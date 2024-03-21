package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_loginRepository extends JpaRepository<User, Integer> {
}
