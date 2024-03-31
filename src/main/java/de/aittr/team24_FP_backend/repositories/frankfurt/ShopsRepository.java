package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_shops_info;
import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_shops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsRepository extends JpaRepository<Frankfurt_shops_info, Integer> {
}
