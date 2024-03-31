package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.hamburg.HamburgChildrenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamburgChildrenRepository extends JpaRepository<HamburgChildrenInfo, Integer> {
}
