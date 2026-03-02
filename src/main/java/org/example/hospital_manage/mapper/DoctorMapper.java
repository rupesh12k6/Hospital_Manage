package org.example.hospital_manage.mapper;

import org.example.hospital_manage.dto.DoctorDto;
import org.example.hospital_manage.entity.Doctor;

public class DoctorMapper {
    public static DoctorDto mapDoctorToDoctorDto(Doctor doctor){
        return new DoctorDto(doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialization(),
                doctor.getLicenceNumber(),
                doctor.getEmail(),
                doctor.getPhone(),
                doctor.getAvailability());

    }
    public static Doctor mapDoctorDtoToDoctor(DoctorDto doctorDto){
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getSpecialization(),
                doctorDto.getLicenceNumber(),
                doctorDto.getEmail(),
                doctorDto.getPhone(),
                doctorDto.getAvailability(),
                null
        );
    }
}
