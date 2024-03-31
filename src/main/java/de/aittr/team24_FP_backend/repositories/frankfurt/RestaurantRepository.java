package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_restaurants_info;
import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_restaurants_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Frankfurt_restaurants_info, Integer> {
}
