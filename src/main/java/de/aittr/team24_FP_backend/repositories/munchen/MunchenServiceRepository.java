package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.munchen.MunchenServicesInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunchenServiceRepository extends JpaRepository<MunchenServicesInfo, Integer> {
}
