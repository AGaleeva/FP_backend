package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
