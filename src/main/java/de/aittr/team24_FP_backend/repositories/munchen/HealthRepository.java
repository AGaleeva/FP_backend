package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_health_info;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_health_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Munchen_health_info, Integer> {
}
