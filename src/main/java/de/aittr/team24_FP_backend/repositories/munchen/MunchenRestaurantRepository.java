package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.munchen.MunchenRestaurantsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunchenRestaurantRepository extends JpaRepository<MunchenRestaurantsInfo, Integer> {
}
