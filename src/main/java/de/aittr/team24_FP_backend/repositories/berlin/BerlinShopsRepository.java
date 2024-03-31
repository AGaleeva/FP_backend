package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinShopsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinShopsRepository extends JpaRepository<BerlinShopsInfo, Integer> {
}
