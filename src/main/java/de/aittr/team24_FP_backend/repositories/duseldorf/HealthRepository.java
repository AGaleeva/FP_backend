package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_health_info;
import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_health_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Duseldorf_health_info, Integer> {
}
