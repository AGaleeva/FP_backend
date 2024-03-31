package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinRestaurantsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinRestaurantRepository extends JpaRepository<BerlinRestaurantsInfo, Integer> {
}
