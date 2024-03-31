package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_children_info;
import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_children_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Hamburg_children_info, Integer> {
}
