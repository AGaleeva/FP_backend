package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.FrankfurtHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrankfurtHealthRepository extends JpaRepository<FrankfurtHealthInfo, Integer> {
}
