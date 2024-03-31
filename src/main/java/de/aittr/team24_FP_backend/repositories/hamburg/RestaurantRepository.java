package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_restaurants_info;
import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_restaurants_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Hamburg_restaurants_info, Integer> {
}
