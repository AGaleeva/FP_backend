package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.MainChildren_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<MainChildren_info, Integer> {
}
