package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_services_info;
import de.aittr.team24_FP_backend.domain.frankfurt.Frankfurt_services_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Frankfurt_services_info, Integer> {
}
