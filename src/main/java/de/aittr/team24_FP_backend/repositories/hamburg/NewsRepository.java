package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_news;
import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_news;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Hamburg_news, Integer> {
}
