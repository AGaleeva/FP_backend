package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.Children_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<Children_info, Integer> {
}
