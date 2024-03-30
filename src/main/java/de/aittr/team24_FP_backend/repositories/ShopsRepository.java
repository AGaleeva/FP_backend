package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.MainShops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsRepository extends JpaRepository<MainShops_info, Integer> {
}
