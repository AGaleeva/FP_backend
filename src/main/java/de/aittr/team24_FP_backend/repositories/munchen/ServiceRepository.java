package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_services_info;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_services_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Munchen_services_info, Integer> {
}
