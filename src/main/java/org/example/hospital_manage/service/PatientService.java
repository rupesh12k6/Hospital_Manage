package org.example.hospital_manage.service;

import org.example.hospital_manage.dto.AppointmentDto;
import org.example.hospital_manage.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto patientDto);
    PatientDto getPatientById(Long id);
    PatientDto updatePatient(Long id, PatientDto patientDto);
   List<PatientDto> getAllPatients();
    PatientDto deletePatientById(Long id);
    List<AppointmentDto> getAppointmentsByPatientId(Long id);
}
