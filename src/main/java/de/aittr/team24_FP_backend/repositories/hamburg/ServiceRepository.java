package de.aittr.team24_FP_backend.repositories.hamburg;

import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_services_info;
import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_services_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Hamburg_services_info, Integer> {
}
