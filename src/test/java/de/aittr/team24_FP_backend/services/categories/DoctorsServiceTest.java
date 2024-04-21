package de.aittr.team24_FP_backend.services.categories;

import de.aittr.team24_FP_backend.domain.categories.DoctorsCategory;
import de.aittr.team24_FP_backend.domain.categories.DoctorsInfo;
import de.aittr.team24_FP_backend.domain.categories.City;
import de.aittr.team24_FP_backend.exception_handling.exceptions.ChildrenNotFoundException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.ChildrenUpdateException;
import de.aittr.team24_FP_backend.exception_handling.exceptions.DoctorNotFoundException;
import de.aittr.team24_FP_backend.repositories.categories.CityRepository;
import de.aittr.team24_FP_backend.repositories.categories.DoctorsCategoryRepository;
import de.aittr.team24_FP_backend.repositories.categories.DoctorsRepository;
import de.aittr.team24_FP_backend.services.email.DatabaseChangeListenerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DoctorsServiceTest {

    @InjectMocks
    private DoctorsService doctorsService;

    @Mock
    private DoctorsRepository doctorsRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private DoctorsCategoryRepository doctorsCategoryRepository;

    @Mock
    private DatabaseChangeListenerService databaseChangeListenerService;

    private DoctorsInfo doctorsInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        doctorsInfo = new DoctorsInfo();

    }

    @Test
    public void saveTest() {
        doctorsInfo.setId(1);
        doctorsInfo.setTitle("Test");

        City city = new City();
        city.setName("Berlin");

        DoctorsCategory doctorsCategory = new DoctorsCategory();
        doctorsCategory.setName("New Category");

        when(cityRepository.findByName(any(String.class))).thenReturn(city);
        when(doctorsCategoryRepository.findByName(any(String.class))).thenReturn(doctorsCategory);
        when(doctorsRepository.save(any(DoctorsInfo.class))).thenReturn(doctorsInfo);

        DoctorsInfo savedDoctor = doctorsService.save(doctorsInfo, "Berlin", "New Category");

        assertEquals(savedDoctor.getId(), doctorsInfo.getId());
        assertEquals(savedDoctor.getTitle(), doctorsInfo.getTitle());
        assertEquals(savedDoctor.getCity().getName(), city.getName());
        assertEquals(savedDoctor.getDoctorsCategory().getName(), doctorsCategory.getName());

        verify(databaseChangeListenerService, times(1)).handleDatabaseChangeDoctorsInfo(any(String.class), any(DoctorsInfo.class));
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

        assertThrows(ChildrenNotFoundException.class, () -> doctorsService.findById(1));
    }

    @Test
    void findAllTest() {
        List<DoctorsInfo> doctorsList = new ArrayList<>();
        doctorsList.add(new DoctorsInfo());
        doctorsList.add(new DoctorsInfo());
        when(doctorsRepository.findByCityName(anyString())).thenReturn(doctorsList);

        List<DoctorsInfo> foundDoctorsList = doctorsService.findAll("Berlin", "New Category");

        assertEquals(foundDoctorsList.size(), foundDoctorsList.size());
        verify(doctorsRepository, times(1)).findByCityName("Berlin");
    }

    @Test
    void findSortAllTest() {
        List<DoctorsInfo> doctorsList = new ArrayList<>();
        doctorsList.add(new DoctorsInfo("a title"));
        doctorsList.add(new DoctorsInfo("b title"));
        doctorsList.add(new DoctorsInfo("c title"));

        when(doctorsRepository.findSortAll("Berlin", "New Category")).thenReturn(doctorsList);

        List<DoctorsInfo> sortedDoctorsList = doctorsService.findSortAll("Berlin", "New Category");

        assertEquals("a title", sortedDoctorsList.get(0).getTitle());
        assertEquals("b title", sortedDoctorsList.get(1).getTitle());
        assertEquals("c title", sortedDoctorsList.get(2).getTitle());

        verify(doctorsRepository, times(1)).findSortAll("Berlin","New Category");
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
    public void findByValidTitleTest() {
        DoctorsInfo doctorsInfo1 = new DoctorsInfo();
        doctorsInfo1.setId(1);
        doctorsInfo1.setTitle("Test1");

        DoctorsInfo doctorsInfo2 = new DoctorsInfo();
        doctorsInfo2.setId(2);
        doctorsInfo2.setTitle("Test2");

        List<DoctorsInfo> doctorsInfoList = Arrays.asList(doctorsInfo1, doctorsInfo2);

        when(doctorsService.findAll(any(String.class), any(String.class))).thenReturn(doctorsInfoList);

        List<DoctorsInfo> foundDoctorsInfoList = doctorsService.findByTitle("Test1", "Berlin", "New Category");

        assertEquals(foundDoctorsInfoList.size(), 1);
        assertEquals(foundDoctorsInfoList.get(0).getTitle(), "Test1");
    }

    @Test
    public void findByNotValidTitleTest() {
        DoctorsInfo doctorsInfo1 = new DoctorsInfo();
        doctorsInfo1.setId(1);
        doctorsInfo1.setTitle("Test1");

        DoctorsInfo doctorsInfo2 = new DoctorsInfo();
        doctorsInfo2.setId(2);
        doctorsInfo2.setTitle("Test2");

        List<DoctorsInfo> doctorsInfoList = Arrays.asList(doctorsInfo1, doctorsInfo2);

        when(doctorsService.findAll(any(String.class), any(String.class))).thenReturn(doctorsInfoList);

        Exception exception = assertThrows(DoctorNotFoundException.class, () -> {
            doctorsService.findByTitle("Test3", "Berlin", "New Category");
        });

        String expectedMessage = "There is no doctors with name [Test3] in the database";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
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

        doctorsService.update(doctorsInfo, "Berlin", "New Category");

        verify(doctorsRepository, times(1)).save(doctorsInfo);
    }

    @Test
    void updateInvalidInfo() {
        doctorsInfo.setId(1);

        when(cityRepository.findByName("Derlin")).thenReturn(null);

        assertThrows(ChildrenUpdateException.class, () -> doctorsService.update(doctorsInfo, "Derlin", "New Category"));

        verify(cityRepository, times(1)).findByName("Derlin");

    }
}
