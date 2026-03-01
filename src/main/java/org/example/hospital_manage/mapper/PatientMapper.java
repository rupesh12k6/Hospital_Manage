package org.example.hospital_manage.mapper;

import org.example.hospital_manage.dto.PatientDto;
import org.example.hospital_manage.entity.Patient;

public class PatientMapper {
    public static PatientDto mapToPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getNumber(),
                patient.getAadhaar(),
                patient.getEmail(),
                patient.getGender(),
                patient.getAge()
        );

    }

    public static Patient mapToPatient(PatientDto patientDto) {
        return new Patient(
                patientDto.getId(),
                patientDto.getFirstName(),
                patientDto.getLastName(),
                patientDto.getNumber(),
                patientDto.getAadhaar(),
                patientDto.getEmail(),
                patientDto.getGender(),
                patientDto.getAge()
        );
    }
}
