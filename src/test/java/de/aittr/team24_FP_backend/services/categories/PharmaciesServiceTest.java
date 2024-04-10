package de.aittr.team24_FP_backend.services.categories;

import de.aittr.team24_FP_backend.domain.categories.City;
import de.aittr.team24_FP_backend.domain.categories.PharmaciesInfo;
import de.aittr.team24_FP_backend.exception_handling.exceptions.ChildrenNotFoundException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.PharmaciesNotFoundException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.PharmaciesUpdateException;
import de.aittr.team24_FP_backend.repositories.categories.CityRepository;
import de.aittr.team24_FP_backend.repositories.categories.PharmaciesRepository;
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

class PharmaciesServiceTest {
    @Mock
    private PharmaciesRepository pharmaciesRepository;

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private PharmaciesService pharmaciesService;

    private PharmaciesInfo pharmaciesInfo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pharmaciesInfo = new PharmaciesInfo();

    }

    @Test
    void saveTest() {
        pharmaciesInfo.setId(1);
        when(cityRepository.findByName(anyString())).thenReturn(new City());
        when(pharmaciesRepository.save(any())).thenReturn(pharmaciesInfo);

        PharmaciesInfo savedPharmaciesInfo = pharmaciesService.save(new PharmaciesInfo(), "Berlin");

        assertEquals(1, savedPharmaciesInfo.getId());
    }

    @Test
    void findByExistingIdTest() {
        pharmaciesInfo.setId(1);
        when(pharmaciesRepository.findById(1)).thenReturn(Optional.of(pharmaciesInfo));

        PharmaciesInfo foundPharmaciesInfo = pharmaciesService.findById(1);

        assertEquals(1, foundPharmaciesInfo.getId());
    }

    @Test
    void findByNotExistingIdTest() {
        when(pharmaciesRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(PharmaciesNotFoundException.class, () -> pharmaciesService.findById(1));
    }

    @Test
    void findAllTest() {
        List<PharmaciesInfo> pharmaciesList = new ArrayList<>();
        pharmaciesList.add(new PharmaciesInfo());
        pharmaciesList.add(new PharmaciesInfo());
        when(pharmaciesRepository.findByCityName(anyString())).thenReturn(pharmaciesList);

        List<PharmaciesInfo> foundPharmaciesList = pharmaciesService.findAll("Berlin");

        assertEquals(pharmaciesList.size(), foundPharmaciesList.size());
        verify(pharmaciesRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    void findSortAllTest() {
        List<PharmaciesInfo> pharmaciesList = new ArrayList<>();
        pharmaciesList.add(new PharmaciesInfo("a title"));
        pharmaciesList.add(new PharmaciesInfo("b title"));
        pharmaciesList.add(new PharmaciesInfo("c title"));

        when(pharmaciesRepository.findSortAll("Berlin")).thenReturn(pharmaciesList);

        List<PharmaciesInfo> sortedPharmaciesList = pharmaciesService.findSortAll("Berlin");

        assertEquals("a title", sortedPharmaciesList.get(0).getTitle());
        assertEquals("b title", sortedPharmaciesList.get(1).getTitle());
        assertEquals("c title", sortedPharmaciesList.get(2).getTitle());

        verify(pharmaciesRepository, times(1)).findSortAll("Berlin");
    }


    @Test
    void deleteByExistingIdTest() {
        when(pharmaciesRepository.findById(1)).thenReturn(Optional.of(new PharmaciesInfo()));

        pharmaciesService.deleteById(1);

        verify(pharmaciesRepository, times(1)).deleteById(1);
    }

    @Test
    void deleteByNotExistingIdTest() {
        when(pharmaciesRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(PharmaciesNotFoundException.class, () -> pharmaciesService.deleteById(1));
    }


    @Test
    void findByValidTitleTest() {
        List<PharmaciesInfo> pharmaciesList = new ArrayList<>();
        pharmaciesList.add(new PharmaciesInfo("a title"));
        pharmaciesList.add(new PharmaciesInfo("b title"));
        pharmaciesList.add(new PharmaciesInfo("a title"));

        when(pharmaciesRepository.findByCityName("Berlin")).thenReturn(pharmaciesList);

        List<PharmaciesInfo> foundPharmaciesList = pharmaciesService.findByTitle("a title", "Berlin");

        assertEquals(2, foundPharmaciesList.size());
        assertEquals("a title", foundPharmaciesList.get(0).getTitle());
        assertEquals("a title", foundPharmaciesList.get(1).getTitle());

        verify(pharmaciesRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    void findByNotValidTitleTest() {
        String title = "title";
        when(pharmaciesRepository.findByCityName("Berlin")).thenReturn(new ArrayList<>());

        assertThrows(PharmaciesNotFoundException.class, () -> pharmaciesService.findByTitle(String.format(
                "There is no pharmacies with name [%s] in the database", title), "Berlin"));

        verify(pharmaciesRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    public void setStatusTest() {
        pharmaciesInfo.setId(1);
        pharmaciesInfo.setStatus(0);

        when(pharmaciesRepository.findById(any(Integer.class))).thenReturn(Optional.of(pharmaciesInfo));

        pharmaciesService.setStatus(1, 1);

        assertEquals(pharmaciesInfo.getStatus(), Integer.valueOf(1));
        verify(pharmaciesRepository, times(1)).findById(1);
    }

    @Test
    void updateValidInfo() {
        pharmaciesInfo.setId(1);

        when(pharmaciesRepository.save(pharmaciesInfo)).thenReturn(pharmaciesInfo);
        when(cityRepository.findByName("Berlin")).thenReturn(new City());

        pharmaciesService.update(pharmaciesInfo, "Berlin");

        verify(pharmaciesRepository, times(1)).save(pharmaciesInfo);
    }

    @Test
    void updateInvalidInfo() {
        pharmaciesInfo.setId(1);

        when(cityRepository.findByName("Derlin")).thenReturn(null);

        assertThrows(PharmaciesUpdateException.class, () -> pharmaciesService.update(pharmaciesInfo, "Derlin"));

        verify(cityRepository, times(1)).findByName("Derlin");

    }

}