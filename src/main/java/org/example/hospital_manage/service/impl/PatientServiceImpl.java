package org.example.hospital_manage.service.impl;

import lombok.AllArgsConstructor;
import org.example.hospital_manage.mapper.PatientMapper;
import org.example.hospital_manage.dto.PatientDto;
import org.example.hospital_manage.entity.Patient;
import org.example.hospital_manage.exception.ResourceNotFoundException;
import org.example.hospital_manage.repository.PatientRepository;
import org.example.hospital_manage.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {
 private PatientRepository patientRepository;
 @Override
    public PatientDto createPatient(PatientDto patientDto) {
     Patient patient= PatientMapper.mapToPatient(patientDto);
     Patient savedPatient=patientRepository.save(patient);
     return PatientMapper.mapToPatientDto(savedPatient);
 }

    @Override
    public PatientDto getPatientById(Long id) {
       Patient patient=patientRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Patient is not found with id:"+id));
       return PatientMapper.mapToPatientDto(patient);

    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
     Patient updatedpatient=patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient is not found with id:"+id));
   if(patientDto.getFirstName()!=null) {
       updatedpatient.setFirstName(patientDto.getFirstName());
   }
   if(patientDto.getLastName()!=null) {
       updatedpatient.setLastName(patientDto.getLastName());
   }
   if(patientDto.getEmail()!=null) {
       updatedpatient.setEmail(patientDto.getEmail());
   }
   if(patientDto.getNumber()!=null) {
       updatedpatient.setNumber(patientDto.getNumber());
   }
   if(patientDto.getAadhaar()!=null) {
       updatedpatient.setAadhaar(patientDto.getAadhaar());
   }
   if(patientDto.getGender()!=null) {
       updatedpatient.setGender(patientDto.getGender());
   }
   if (patientDto.getAge()!=null){
       updatedpatient.setAge(patientDto.getAge());
   }
     updatedpatient=patientRepository.save(updatedpatient);
     return PatientMapper.mapToPatientDto(updatedpatient);

    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients=patientRepository.findAll();
       return patients.stream().map((patient) -> PatientMapper.mapToPatientDto(patient)).collect(Collectors.toList());
    }

    @Override
    public PatientDto deletePatientById(Long id) {

     Patient patient=patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found"));
        patientRepository.deleteById(id);
        return PatientMapper.mapToPatientDto(patient);
    }


}
