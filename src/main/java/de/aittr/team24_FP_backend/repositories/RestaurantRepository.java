package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.Restaurants_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurants_info, Integer> {
}
