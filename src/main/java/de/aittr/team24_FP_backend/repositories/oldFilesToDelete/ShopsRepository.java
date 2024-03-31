package de.aittr.team24_FP_backend.repositories.oldFilesToDelete;

import de.aittr.team24_FP_backend.domain.oldFilesToDelete.MainShops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsRepository extends JpaRepository<MainShops_info, Integer> {
}
