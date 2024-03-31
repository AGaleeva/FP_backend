package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_shops_info;
import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_shops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsRepository extends JpaRepository<Hamburg_shops_info, Integer> {
}
