package org.example.hospital_manage.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.hospital_manage.dto.PatientDto;
import org.example.hospital_manage.repository.PatientRepository;
import org.example.hospital_manage.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;

    //Building the POST API end point
    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody @Valid PatientDto patientDto) {
        PatientDto savedPatient=patientService.createPatient(patientDto);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Building API for retriving of the data
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable("id") Long id){
        PatientDto savedPatient=patientService.getPatientById(id);
        return ResponseEntity.ok(savedPatient);
    }

    //Building Api for printing all the reocrds
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List<PatientDto> patientsdto=patientService.getAllPatients();
        return  ResponseEntity.ok(patientsdto);
    }

    //Building Api for Deleting teh record
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatientById(@PathVariable("id") Long id){
        PatientDto deletedPatient=patientService.deletePatientById(id);
        return ResponseEntity.ok("Patient deleted ");
    }

    //Building Api for updation of the record
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> updatePatientById(@PathVariable("id") Long id, @RequestBody PatientDto patientDto){

        patientService.updatePatient(id, patientDto);
        return  ResponseEntity.ok(patientDto);
    }
}
