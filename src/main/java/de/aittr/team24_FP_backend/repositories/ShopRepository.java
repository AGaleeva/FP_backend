package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.interfaces.Shops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shops_info, Integer> {
}
