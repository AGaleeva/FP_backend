package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.hamburg.HamburgHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamburgHealthRepository extends JpaRepository<HamburgHealthInfo, Integer> {
}
