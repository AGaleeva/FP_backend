package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinChildrenRepository extends JpaRepository<BerlinChildrenInfo, Integer> {
}
