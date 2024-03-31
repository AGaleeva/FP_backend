package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_news;
import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_news;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<Duseldorf_news, Integer> {
}
