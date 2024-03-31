package de.aittr.team24_FP_backend.repositories.oldFilesToDelete;

import de.aittr.team24_FP_backend.domain.oldFilesToDelete.MainServices_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<MainServices_info, Integer> {
}
