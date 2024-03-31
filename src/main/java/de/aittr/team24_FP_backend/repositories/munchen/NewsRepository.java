package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_news;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_news;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Munchen_news, Integer> {
}
