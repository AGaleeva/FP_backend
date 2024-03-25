package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.Services_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Services_info, Integer> {
}
