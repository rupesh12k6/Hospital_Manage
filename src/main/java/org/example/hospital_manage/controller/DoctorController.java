package org.example.hospital_manage.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.hospital_manage.dto.DoctorDto;
import org.example.hospital_manage.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {
    private DoctorService doctorService;
    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody  DoctorDto doctorDto){
        doctorService.addDoctor(doctorDto);
        return ResponseEntity.ok(doctorDto);
    }
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        return  ResponseEntity.ok(doctorService.getAllDoctors());
    }


    @GetMapping("speciality/{speciality}")
    public ResponseEntity<List<DoctorDto>> getDoctorsBySpeciality(@PathVariable("speciality") String speciality){
        return  ResponseEntity.ok(doctorService.getDoctorsBySpecialization(speciality));
    }


    @PutMapping("{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long id, @RequestBody DoctorDto doctorDto){
        doctorService.updateDoctor(id, doctorDto);
        return ResponseEntity.ok(doctorDto);
    }


    @GetMapping("licence/{Licence}")
    public ResponseEntity<DoctorDto> getDoctorByLicence(@PathVariable("Licence") String licence){
        return  ResponseEntity.ok(doctorService.getDoctorByLicence(licence));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctorById(id);
        return ResponseEntity.ok("Doctor with ID: "+id+" Deleted");
    }
    @PutMapping("/status/{id}/{availability}")
    public ResponseEntity<String> updateDoctorStatus(@PathVariable("id") Long id, @PathVariable("availability") String availability){
        doctorService.setDoctorAvailabilityById(id,availability);
        return ResponseEntity.ok("Doctor with ID: "+id+" is now" +availability);
    }
}
