package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinNewsRepository extends JpaRepository<BerlinNews, Integer> {
}
