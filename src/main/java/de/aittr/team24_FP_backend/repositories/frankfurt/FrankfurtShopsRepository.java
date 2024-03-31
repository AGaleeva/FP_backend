package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.FrankfurtShopsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrankfurtShopsRepository extends JpaRepository<FrankfurtShopsInfo, Integer> {
}
