package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_cultural_life_info;
import de.aittr.team24_FP_backend.domain.interfaces.Cultural_life_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cultural_lifeRepository extends JpaRepository<Duseldorf_cultural_life_info, Integer> {
}
