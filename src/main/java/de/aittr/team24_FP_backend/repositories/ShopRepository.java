package de.aittr.team24_FP_backend.repositories;

import de.aittr.team24_FP_backend.domain.interfaces.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
