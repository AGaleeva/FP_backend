package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.MainUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MainUser, Integer> {

}
