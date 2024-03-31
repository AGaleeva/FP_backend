package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.DuseldorfNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuseldorfNewsRepository extends JpaRepository<DuseldorfNews, Integer> {
}
