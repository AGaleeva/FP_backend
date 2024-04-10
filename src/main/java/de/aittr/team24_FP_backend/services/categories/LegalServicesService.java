package de.aittr.team24_FP_backend.services.categories;

import de.aittr.team24_FP_backend.domain.categories.LegalServicesInfo;
import de.aittr.team24_FP_backend.domain.categories.City;
import de.aittr.team24_FP_backend.exception_handling.exceptions.*;
import de.aittr.team24_FP_backend.repositories.categories.CityRepository;
import de.aittr.team24_FP_backend.repositories.categories.LegalServicesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalServicesService {

    private LegalServicesRepository legalServicesRepository;
    private CityRepository cityRepository;

    public LegalServicesService(LegalServicesRepository legalServicesRepository, CityRepository cityRepository) {
        this.legalServicesRepository = legalServicesRepository;
        this.cityRepository = cityRepository;
    }
    public LegalServicesInfo save(LegalServicesInfo legalServicesInfo, String cityName) {
        try {
            legalServicesInfo.setId(0);
            City city = cityRepository.findByName(cityName);
            legalServicesInfo.setCity(city);
            return legalServicesRepository.save(legalServicesInfo);
        } catch (Exception e) {
            throw new LegalServiceValidationException("Incorrect values of legalService fields", e);
        }
    }

    public LegalServicesInfo findById (int id) {
        LegalServicesInfo legalService = legalServicesRepository.findById(id).orElse(null);

        if (legalService == null) {
            throw new LegalServiceNotFoundException(String.format(
                    "There is no legalService with id [%d] in the database", id));
        }
        return legalService;
    }

    public List<LegalServicesInfo> findAll(String cityName) {
        return legalServicesRepository.findByCityName(cityName);
    }
    public List<LegalServicesInfo> findSortAll(String cityName) {
        return legalServicesRepository.findSortAll(cityName);
    }


    @Transactional
    public void setStatus(Integer id, Integer status) {
        LegalServicesInfo legalService = legalServicesRepository.findById(id).orElse(null);

        if (legalService != null) {
            legalService.setStatus(status);
        } else {
            throw new LegalServiceNotFoundException(String.format(
                    "There is no legalService with id [%d] in the database", id));
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        LegalServicesInfo legalService = legalServicesRepository.findById(id).orElse(null);

        if (legalService != null) {
            legalServicesRepository.deleteById(id);
        } else {
            throw new LegalServiceNotFoundException(String.format(
                    "There is no legalService with id [%d] in the database", id));
        }
    }

    public List<LegalServicesInfo> findByTitle(String title, String cityName) {
        List<LegalServicesInfo> list = findAll(cityName).stream().filter((r) -> r.getTitle().equalsIgnoreCase(title.trim())).toList();
        if (list.isEmpty()) {
            throw new LegalServiceNotFoundException(String.format(
                    "There is no legalService with name [%s] in the database", title));
        }
        return list;
    }

    public void update(LegalServicesInfo legalService, String cityName) {
//        try {
//            City city = cityRepository.findByName(cityName);
//            legalService.setCity(city);
//            legalServicesRepository.save(legalService);
//        } catch (Exception e) {
//            throw new LegalServiceUpdateException("Error updating legalService: " + e.getMessage());
//        }
        try {
            City city = cityRepository.findByName(cityName);
            if (city == null) {
                throw new ChildrenUpdateException("Invalid city name: " + cityName);
            }
            legalService.setCity(city);
            legalServicesRepository.save(legalService);
        } catch (Exception e) {
            throw new LegalServiceUpdateException("Error updating: " + e.getMessage());
        }

    }

}
