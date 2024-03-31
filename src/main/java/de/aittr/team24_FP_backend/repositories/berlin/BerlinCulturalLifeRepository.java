package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinCulturalLifeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinCulturalLifeRepository extends JpaRepository<BerlinCulturalLifeInfo, Integer> {
}
