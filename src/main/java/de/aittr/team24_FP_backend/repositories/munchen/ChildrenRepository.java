package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_children_info;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_children_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Munchen_children_info, Integer> {
}
