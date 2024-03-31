package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.hamburg.HamburgNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamburgNewsRepository extends JpaRepository<HamburgNews, Integer> {
}
