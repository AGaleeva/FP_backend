package de.aittr.team24_FP_backend.repositories.oldFilesToDelete;

import de.aittr.team24_FP_backend.domain.oldFilesToDelete.MainChildren_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepository extends JpaRepository<MainChildren_info, Integer> {
}
