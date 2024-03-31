package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_cultural_life_info;
import de.aittr.team24_FP_backend.domain.interfaces.Cultural_life_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cultural_lifeRepository extends JpaRepository<Frankfurt_cultural_life_info, Integer> {
}
