package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_restaurants_info;
import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_restaurants_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Duseldorf_restaurants_info, Integer> {
}
