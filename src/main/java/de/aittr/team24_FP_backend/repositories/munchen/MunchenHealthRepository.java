package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.munchen.MunchenHealthInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunchenHealthRepository extends JpaRepository<MunchenHealthInfo, Integer> {
}
