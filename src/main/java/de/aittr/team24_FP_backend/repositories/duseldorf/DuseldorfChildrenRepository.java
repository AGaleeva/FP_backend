package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.DuseldorfChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuseldorfChildrenRepository extends JpaRepository<DuseldorfChildrenInfo, Integer> {
}
