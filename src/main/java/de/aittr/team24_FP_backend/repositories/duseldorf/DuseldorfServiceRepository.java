package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.DuseldorfServicesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuseldorfServiceRepository extends JpaRepository<DuseldorfServicesInfo, Integer> {
}
