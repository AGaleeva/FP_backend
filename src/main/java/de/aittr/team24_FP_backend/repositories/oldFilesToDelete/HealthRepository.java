package de.aittr.team24_FP_backend.repositories.oldFilesToDelete;

import de.aittr.team24_FP_backend.domain.oldFilesToDelete.MainHealth_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<MainHealth_info, Integer> {
}
