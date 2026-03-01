package org.example.hospital_manage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    Long id;
    LocalDateTime appointmentDate;
    String status;
    DoctorDto doctorDto;
    PatientDto patientDto;

}
