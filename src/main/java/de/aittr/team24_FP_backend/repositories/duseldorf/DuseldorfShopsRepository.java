package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.DuseldorfShopsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuseldorfShopsRepository extends JpaRepository<DuseldorfShopsInfo, Integer> {
}
