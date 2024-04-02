package de.aittr.team24_FP_backend.repositories.duseldorf;

import de.aittr.team24_FP_backend.domain.duseldorf.DuseldorfRestaurantsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuseldorfRestaurantsRepository extends JpaRepository<DuseldorfRestaurantsInfo, Integer> {
}
