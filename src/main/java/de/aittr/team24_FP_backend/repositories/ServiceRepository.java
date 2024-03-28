package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.MainServices_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<MainServices_info, Integer> {
}
