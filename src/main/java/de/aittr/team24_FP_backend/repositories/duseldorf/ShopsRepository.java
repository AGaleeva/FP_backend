package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.berlin.Berlin_shops_info;
import de.aittr.team24_FP_backend.domain.duseldorf.Duseldorf_shops_info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopsRepository extends JpaRepository<Duseldorf_shops_info, Integer> {
}
