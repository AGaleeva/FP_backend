package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_news;
import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_news;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Frankfurt_news, Integer> {
}
