package de.aittr.team24_FP_backend.services.categories;

import de.aittr.team24_FP_backend.domain.categories.PharmaciesInfo;
import de.aittr.team24_FP_backend.domain.categories.City;
import de.aittr.team24_FP_backend.exception_handling.exceptions.*;
import de.aittr.team24_FP_backend.repositories.categories.CityRepository;
import de.aittr.team24_FP_backend.repositories.categories.PharmaciesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmaciesService {

    private PharmaciesRepository pharmaciesRepository;
    private CityRepository cityRepository;

    public PharmaciesService(PharmaciesRepository pharmaciesRepository, CityRepository cityRepository) {
        this.pharmaciesRepository = pharmaciesRepository;
        this.cityRepository = cityRepository;
    }
    public PharmaciesInfo save(PharmaciesInfo pharmaciesInfo, String cityName) {
        try {
            pharmaciesInfo.setId(0);
            City city = cityRepository.findByName(cityName);
            pharmaciesInfo.setCity(city);
            return pharmaciesRepository.save(pharmaciesInfo);
        } catch (Exception e) {
            throw new PharmaciesValidationException("Incorrect values of pharmacies fields", e);
        }
    }

    public PharmaciesInfo findById (int id) {
        PharmaciesInfo pharmacies = pharmaciesRepository.findById(id).orElse(null);

        if (pharmacies == null) {
            throw new PharmaciesNotFoundException(String.format(
                    "There is no pharmacies with id [%d] in the database", id));
        }
        return pharmacies;
    }

    public List<PharmaciesInfo> findAll(String cityName) {
        return pharmaciesRepository.findByCityName(cityName);
    }
    public List<PharmaciesInfo> findSortAll(String cityName) {
        return pharmaciesRepository.findSortAll(cityName);
    }


    @Transactional
    public void setStatus(Integer id, Integer status) {
        PharmaciesInfo pharmacies = pharmaciesRepository.findById(id).orElse(null);

        if (pharmacies != null) {
            pharmacies.setStatus(status);
        } else {
            throw new PharmaciesNotFoundException(String.format(
                    "There is no pharmacies with id [%d] in the database", id));
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        PharmaciesInfo pharmacies = pharmaciesRepository.findById(id).orElse(null);

        if (pharmacies != null) {
            pharmaciesRepository.deleteById(id);
        } else {
            throw new PharmaciesNotFoundException(String.format(
                    "There is no pharmacies with id [%d] in the database", id));
        }
    }

    public List<PharmaciesInfo> findByTitle(String title, String cityName) {
        List<PharmaciesInfo> list = findAll(cityName).stream().filter((r) -> r.getTitle().equalsIgnoreCase(title.trim())).toList();
        if (list.isEmpty()) {
            throw new PharmaciesNotFoundException(String.format(
                    "There is no pharmacies with name [%s] in the database", title));
        }
        return list;
    }

    public void update(PharmaciesInfo pharmacies, String cityName) {
//        try {
//            City city = cityRepository.findByName(cityName);
//            pharmacies.setCity(city);
//            pharmaciesRepository.save(pharmacies);
//        } catch (Exception e) {
//            throw new PharmaciesUpdateException("Error updating pharmacies: " + e.getMessage());
//        }
        try {
            City city = cityRepository.findByName(cityName);
            if (city == null) {
                throw new ChildrenUpdateException("Invalid city name: " + cityName);
            }
            pharmacies.setCity(city);
            pharmaciesRepository.save(pharmacies);
        } catch (Exception e) {
            throw new PharmaciesUpdateException("Error updating: " + e.getMessage());
        }

    }

}
