package de.aittr.team24_FP_backend.repositories.munchen;

import de.aittr.team24_FP_backend.domain.hamburg.Hamburg_shops_info;
import de.aittr.team24_FP_backend.domain.munchen.Munchen_shops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsRepository extends JpaRepository<Munchen_shops_info, Integer> {
}
