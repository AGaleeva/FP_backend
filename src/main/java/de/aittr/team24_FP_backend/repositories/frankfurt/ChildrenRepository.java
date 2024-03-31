package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_children_info;
import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_children_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Frankfurt_children_info, Integer> {
}
