package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.munchen.MunchenChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunchenChildrenRepository extends JpaRepository<MunchenChildrenInfo, Integer> {
}
