package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_health_info;
import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_health_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Hamburg_health_info, Integer> {
}
