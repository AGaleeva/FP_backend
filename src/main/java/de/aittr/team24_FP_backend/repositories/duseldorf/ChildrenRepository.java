package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_children_info;
import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_children_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Duseldorf_children_info, Integer> {
}
