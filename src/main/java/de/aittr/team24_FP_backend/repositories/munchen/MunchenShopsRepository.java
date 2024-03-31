package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.munchen.MunchenShopsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunchenShopsRepository extends JpaRepository<MunchenShopsInfo, Integer> {
}
