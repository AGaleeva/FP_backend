package de.aittr.team24_FP_backend.repositories.berlin;

import de.aittr.team24_FP_backend.domain.berlin.BerlinServicesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BerlinServicesRepository extends JpaRepository<BerlinServicesInfo, Integer> {
}
