package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.hamburg.HamburgRestaurantsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamburgRestaurantRepository extends JpaRepository<HamburgRestaurantsInfo, Integer> {
}
