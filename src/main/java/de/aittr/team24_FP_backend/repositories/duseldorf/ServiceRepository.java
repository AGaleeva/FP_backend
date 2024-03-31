package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_services_info;
import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_services_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Duseldorf_services_info, Integer> {
}
