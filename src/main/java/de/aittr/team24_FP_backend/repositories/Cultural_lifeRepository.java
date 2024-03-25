package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.Cultural_life_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cultural_lifeRepository extends JpaRepository<Cultural_life_info, Integer> {
}
