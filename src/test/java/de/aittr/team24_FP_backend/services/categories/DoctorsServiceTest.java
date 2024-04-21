package de.aittr.team24_FP_backend.services.categories;

import de.aittr.team24_FP_backend.domain.categories.City;
import de.aittr.team24_FP_backend.domain.categories.DoctorsInfo;
import de.aittr.team24_FP_backend.exception_handling.exceptions.DoctorNotFoundException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.DoctorUpdateException;
import de.aittr.team24_FP_backend.repositories.categories.CityRepository;
import de.aittr.team24_FP_backend.repositories.categories.DoctorsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DoctorsServiceTest {
    @Mock
    private DoctorsRepository doctorsRepository;

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private DoctorsService doctorsService;

    private DoctorsInfo doctorsInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doctorsInfo = new DoctorsInfo();

    }

    @Test
    void saveTest() {
        doctorsInfo.setId(1);
        when(cityRepository.findByName(anyString())).thenReturn(new City());
        when(doctorsRepository.save(any())).thenReturn(doctorsInfo);

        DoctorsInfo savedDoctorsInfo = doctorsService.save(new DoctorsInfo(), "Berlin");

        assertEquals(1, savedDoctorsInfo.getId());
    }

    @Test
    void findByExistingIdTest() {
        doctorsInfo.setId(1);
        when(doctorsRepository.findById(1)).thenReturn(Optional.of(doctorsInfo));

        DoctorsInfo foundDoctorsInfo = doctorsService.findById(1);

        assertEquals(1, foundDoctorsInfo.getId());
    }

    @Test
    void findByNotExistingIdTest() {
        when(doctorsRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(DoctorNotFoundException.class, () -> doctorsService.findById(1));
    }

    @Test
    void findAllTest() {
        List<DoctorsInfo> doctorList = new ArrayList<>();
        doctorList.add(new DoctorsInfo());
        doctorList.add(new DoctorsInfo());
        when(doctorsRepository.findByCityName(anyString())).thenReturn(doctorList);

        List<DoctorsInfo> foundChildrenList = doctorsService.findAll("Berlin");

        assertEquals(doctorList.size(), foundChildrenList.size());
        verify(doctorsRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    void findSortAllTest() {
        List<DoctorsInfo> doctorList = new ArrayList<>();
        doctorList.add(new DoctorsInfo("a title"));
        doctorList.add(new DoctorsInfo("b title"));
        doctorList.add(new DoctorsInfo("c title"));

        when(doctorsRepository.findSortAll("Berlin")).thenReturn(doctorList);

        List<DoctorsInfo> sortedDoctorList = doctorsService.findSortAll("Berlin");

        assertEquals("a title", sortedDoctorList.get(0).getTitle());
        assertEquals("b title", sortedDoctorList.get(1).getTitle());
        assertEquals("c title", sortedDoctorList.get(2).getTitle());

        verify(doctorsRepository, times(1)).findSortAll("Berlin");
    }


    @Test
    void deleteByExistingIdTest() {
        when(doctorsRepository.findById(1)).thenReturn(Optional.of(new DoctorsInfo()));

        doctorsService.deleteById(1);

        verify(doctorsRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteByNotExistingIdTest() {
        when(doctorsRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(DoctorNotFoundException.class, () -> doctorsService.deleteById(1));
    }


    @Test
    void findByValidTitleTest() {
        List<DoctorsInfo> doctorList = new ArrayList<>();
        doctorList.add(new DoctorsInfo("a title"));
        doctorList.add(new DoctorsInfo("b title"));
        doctorList.add(new DoctorsInfo("a title"));

        when(doctorsRepository.findByCityName("Berlin")).thenReturn(doctorList);

        List<DoctorsInfo> foundDoctorList = doctorsService.findByTitle("a title", "Berlin");

        assertEquals(2, foundDoctorList.size());
        assertEquals("a title", foundDoctorList.get(0).getTitle());
        assertEquals("a title", foundDoctorList.get(1).getTitle());

        verify(doctorsRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    void findByNotValidTitleTest() {
        String title = "title";
        when(doctorsRepository.findByCityName("Berlin")).thenReturn(new ArrayList<>());

        assertThrows(DoctorNotFoundException.class, () -> doctorsService.findByTitle(String.format(
                "There is no doctors with name [%s] in the database", title), "Berlin"));

        verify(doctorsRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    public void setStatusTest() {
        doctorsInfo.setId(1);
        doctorsInfo.setStatus(0);

        when(doctorsRepository.findById(any(Integer.class))).thenReturn(Optional.of(doctorsInfo));

        doctorsService.setStatus(1, 1);

        assertEquals(doctorsInfo.getStatus(), Integer.valueOf(1));
        verify(doctorsRepository, times(1)).findById(1);
    }

    @Test
    void updateValidInfo() {
        doctorsInfo.setId(1);

        when(doctorsRepository.save(doctorsInfo)).thenReturn(doctorsInfo);
        when(cityRepository.findByName("Berlin")).thenReturn(new City());

        doctorsService.update(doctorsInfo, "Berlin");

        verify(doctorsRepository, times(1)).save(doctorsInfo);
    }

    @Test
    void updateInvalidInfo() {
        doctorsInfo.setId(1);

        when(cityRepository.findByName("Derlin")).thenReturn(null);

        assertThrows(DoctorUpdateException.class, () -> doctorsService.update(doctorsInfo, "Derlin"));

        verify(cityRepository, times(1)).findByName("Derlin");
    }
}