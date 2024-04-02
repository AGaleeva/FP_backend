package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.FrankfurtRestaurantsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrankfurtRestaurantsRepository extends JpaRepository<FrankfurtRestaurantsInfo, Integer> {
}
