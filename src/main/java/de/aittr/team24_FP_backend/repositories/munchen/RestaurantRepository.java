package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_restaurants_info;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_restaurants_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Munchen_restaurants_info, Integer> {
}
