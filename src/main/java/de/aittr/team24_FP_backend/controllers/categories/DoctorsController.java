package de.aittr.team24_FP_backend.controllers.categories;

import de.aittr.team24_FP_backend.domain.categories.DoctorsInfo;
import de.aittr.team24_FP_backend.services.categories.DoctorsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{city}/doctors_info")
public class DoctorsController {
    
    private DoctorsService service;

    public DoctorsController(DoctorsService service) {
        this.service = service;
    }
    
    @Operation(summary = "Save")
    @PostMapping("/admin")
    public DoctorsInfo save(@RequestBody DoctorsInfo doctor, @PathVariable String city) {
        return service.save(doctor, city);
    }

    @Operation(summary = "findById")
    @GetMapping("/admin/{id}")
    public DoctorsInfo findById(@PathVariable int id) {
        return service.findById(id);
    }

    @Operation(summary = "findAll")
    @GetMapping("/admin/findAll")
    public List<DoctorsInfo> findAll(@PathVariable String city) {
        return service.findAll(city);
    }

    @Operation(summary = "setStatus")
    @PutMapping("/admin/{id}/{status}")
    public void setStatus(@PathVariable Integer id, @PathVariable Integer status) {
        service.setStatus(id, status);
    }

    @Operation(summary = "deleteById")
    @DeleteMapping("/admin/{id}")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @Operation(summary = "findSortAll")
    @GetMapping
    public List<DoctorsInfo> findSortAll(@PathVariable String city) {
        return service.findSortAll(city);
    }

    @Operation(summary = "findByTitle")
    @GetMapping("find_by_title/{title}")
    public List<DoctorsInfo> findByTitle(@PathVariable String title, @PathVariable String city) {
        return service.findByTitle(title, city);
    }

    @Operation(summary = "update")
    @PutMapping("/admin")
    public void update(@RequestBody DoctorsInfo doctor, @PathVariable String city) {
        service.update(doctor, city);
    }
}
