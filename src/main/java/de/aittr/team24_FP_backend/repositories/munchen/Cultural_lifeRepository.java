package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_cultural_life_info;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_cultural_life_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cultural_lifeRepository extends JpaRepository<Munchen_cultural_life_info, Integer> {
}
