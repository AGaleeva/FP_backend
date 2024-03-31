package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinHealthRepository extends JpaRepository<BerlinHealthInfo, Integer> {
}
