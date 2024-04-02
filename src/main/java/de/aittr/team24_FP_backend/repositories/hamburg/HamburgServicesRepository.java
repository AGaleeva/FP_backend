package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.hamburg.HamburgServicesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HamburgServicesRepository extends JpaRepository<HamburgServicesInfo, Integer> {
}
