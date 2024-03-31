package de.aittr.team24_FP_backend.repositories.frankfurt;

import de.aittr.team24_FP_backend.domain.frankfurt.FrankfurtServicesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrankfurtServiceRepository extends JpaRepository<FrankfurtServicesInfo, Integer> {
}
