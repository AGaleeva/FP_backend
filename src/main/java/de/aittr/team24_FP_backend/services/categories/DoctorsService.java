package de.aittr.team24_FP_backend.services.categories;

import de.aittr.team24_FP_backend.domain.categories.DoctorsInfo;
import de.aittr.team24_FP_backend.domain.categories.City;
import de.aittr.team24_FP_backend.exception_handling.exceptions.DoctorUpdateException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.DoctorValidationException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.DoctorNotFoundException;
import de.aittr.team24_FP_backend.repositories.categories.CityRepository;
import de.aittr.team24_FP_backend.repositories.categories.DoctorsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsService {

    private DoctorsRepository doctorsRepository;
    private CityRepository cityRepository;

    public DoctorsService(DoctorsRepository doctorsRepository, CityRepository cityRepository) {
        this.doctorsRepository = doctorsRepository;
        this.cityRepository = cityRepository;
    }
    public DoctorsInfo save(DoctorsInfo doctors, String cityName) {
        try {
            doctors.setId(0);
            City city = cityRepository.findByName(cityName);
            doctors.setCity(city);
            return doctorsRepository.save(doctors);
        } catch (Exception e) {
            throw new DoctorValidationException("Incorrect values of doctor fields", e);
        }
    }

    public DoctorsInfo findById (int id) {
        DoctorsInfo doctor = doctorsRepository.findById(id).orElse(null);

        if (doctor == null) {
            throw new DoctorNotFoundException(String.format(
                    "There is no doctor with id [%d] in the database", id));
        }
        return doctor;
    }

    public List<DoctorsInfo> findAll(String cityName) {
        return doctorsRepository.findByCityName(cityName);
    }
    public List<DoctorsInfo> findSortAll(String cityName) {
        return doctorsRepository.findSortAll(cityName);
    }


    @Transactional
    public void setStatus(Integer id, Integer status) {
        DoctorsInfo doctor = doctorsRepository.findById(id).orElse(null);

        if (doctor != null) {
            doctor.setStatus(status);
        } else {
            throw new DoctorNotFoundException(String.format(
                    "There is no doctors with id [%d] in the database", id));
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        DoctorsInfo doctor = doctorsRepository.findById(id).orElse(null);

        if (doctor != null) {
            doctorsRepository.deleteById(id);
        } else {
            throw new DoctorNotFoundException(String.format(
                    "There is no doctors with id [%d] in the database", id));
        }
    }

    public List<DoctorsInfo> findByTitle(String title, String cityName) {
        List<DoctorsInfo> list = findAll(cityName).stream().filter((r) -> r.getTitle().equalsIgnoreCase(title.trim())).toList();
        if (list.isEmpty()) {
            throw new DoctorNotFoundException(String.format(
                    "There is no doctors with name [%s] in the database", title));
        }
        return list;
    }

    public void update(DoctorsInfo doctor, String cityName) {
        try {
            City city = cityRepository.findByName(cityName);
            doctor.setCity(city);
            doctorsRepository.save(doctor);
        } catch (Exception e) {
            throw new DoctorUpdateException("Error updating doctor: " + e.getMessage());
        }

    }

}
