package de.aittr.team24_FP_backend.repositories.oldFilesToDelete;

import de.aittr.team24_FP_backend.domain.oldFilesToDelete.MainRestaurants_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<MainRestaurants_info, Integer> {
}
