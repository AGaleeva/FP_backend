package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.DuseldorfHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuseldorfHealthRepository extends JpaRepository<DuseldorfHealthInfo, Integer> {
}
