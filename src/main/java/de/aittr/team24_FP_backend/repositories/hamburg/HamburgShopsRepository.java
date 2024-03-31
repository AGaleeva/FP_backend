package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.hamburg.HamburgShopsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamburgShopsRepository extends JpaRepository<HamburgShopsInfo, Integer> {
}
