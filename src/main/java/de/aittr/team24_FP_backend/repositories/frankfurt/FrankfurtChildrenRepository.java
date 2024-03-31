package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.FrankfurtChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrankfurtChildrenRepository extends JpaRepository<FrankfurtChildrenInfo, Integer> {
}
