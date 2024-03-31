package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_health_info;
import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_health_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Frankfurt_health_info, Integer> {
}
