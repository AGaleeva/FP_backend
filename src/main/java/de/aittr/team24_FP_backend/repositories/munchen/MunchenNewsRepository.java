package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.munchen.MunchenNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunchenNewsRepository extends JpaRepository<MunchenNews, Integer> {
}
