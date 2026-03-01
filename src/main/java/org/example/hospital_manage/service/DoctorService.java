package org.example.hospital_manage.service;

import org.example.hospital_manage.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
  DoctorDto addDoctor(DoctorDto doctorDto);
  DoctorDto getDoctorByLicence(String licence);
  DoctorDto updateDoctor(Long Id,DoctorDto doctorDto);
  DoctorDto deleteDoctorById(Long id);
  List<DoctorDto> getAllDoctors();
  List<DoctorDto> getDoctorsBySpecialization(String name);
  DoctorDto setDoctorAvailabilityById(Long doctorId,String availability);

}
