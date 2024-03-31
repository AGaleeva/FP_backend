package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.FrankfurtNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrankfurtNewsRepository extends JpaRepository<FrankfurtNews, Integer> {
}
