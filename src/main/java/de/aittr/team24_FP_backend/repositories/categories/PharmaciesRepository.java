package de.aittr.team24_FP_backend.repositories.categories;

import de.aittr.team24_FP_backend.domain.categories.PharmaciesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmaciesRepository extends JpaRepository<PharmaciesInfo, Integer> {
    @Query(value = "SELECT i.* " +
            "FROM pharmacies_info i " +
            "INNER JOIN city c ON i.city_id = c.id " +
            "WHERE c.name = :cityName " +
            "ORDER BY i.status DESC, i.title ASC", nativeQuery = true)
    List<PharmaciesInfo> findSortAll(String cityName);

    List<PharmaciesInfo> findByCityName(String name);

}
