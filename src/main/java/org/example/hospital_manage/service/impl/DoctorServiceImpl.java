package org.example.hospital_manage.service.impl;

import lombok.AllArgsConstructor;
import org.example.hospital_manage.dto.DoctorDto;
import org.example.hospital_manage.entity.Doctor;
import org.example.hospital_manage.exception.ResourceNotFoundException;
import org.example.hospital_manage.mapper.DoctorMapper;
import org.example.hospital_manage.repository.DoctorRepository;
import org.example.hospital_manage.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        doctorDto.setSpecialization( doctorDto.getSpecialization().toUpperCase());
       return DoctorMapper.mapDoctorToDoctorDto(doctorRepository.save(DoctorMapper.mapDoctorDtoToDoctor(doctorDto)));
    }

    @Override
    public DoctorDto getDoctorByLicence(String licence) {
        Doctor doctor = doctorRepository.findByLicenceNumber(licence);
        if(doctor == null){
            throw new ResourceNotFoundException("Doctor not found"+licence);
        }
        return DoctorMapper.mapDoctorToDoctorDto(doctor);
    }

    @Override
    public DoctorDto updateDoctor(Long Id ,DoctorDto doctorDto) {
        doctorDto.setSpecialization( doctorDto.getSpecialization().toUpperCase());
     Doctor updatedDoctor = doctorRepository.findDoctorById(Id);
         updatedDoctor.setEmail(doctorDto.getEmail());
         updatedDoctor.setFirstName(doctorDto.getFirstName());
         updatedDoctor.setLastName(doctorDto.getLastName());
         updatedDoctor.setPhone(doctorDto.getPhone());
         updatedDoctor.setLicenceNumber(doctorDto.getLicenceNumber());
         updatedDoctor.setSpecialization(doctorDto.getSpecialization());
         updatedDoctor.setAvailability(doctorDto.getAvailability());
        return DoctorMapper.mapDoctorToDoctorDto(doctorRepository.save(updatedDoctor));
    }

    @Override
    public DoctorDto deleteDoctorById(Long id) {
        Doctor doctor = doctorRepository.findDoctorById(id);
        doctorRepository.delete(doctor);
        return DoctorMapper.mapDoctorToDoctorDto(doctor);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map((doctor)->DoctorMapper.mapDoctorToDoctorDto(doctor)).collect(Collectors.toList());
    }

    @Override
    public List<DoctorDto> getDoctorsBySpecialization(String specality) {
        specality = specality.toUpperCase();
        List<Doctor> doctors =doctorRepository.findAllBySpecialization(specality);
        return doctors.stream().map((doctor)->DoctorMapper.mapDoctorToDoctorDto(doctor)).collect(Collectors.toList());

    }

    @Override
    public DoctorDto setDoctorAvailabilityById(Long doctorId, String availability) {
        Doctor updateddoctor=doctorRepository.findDoctorById(doctorId);
        updateddoctor.setAvailability(availability);
        doctorRepository.save(updateddoctor);
        return DoctorMapper.mapDoctorToDoctorDto(updateddoctor);
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        Doctor doctor=doctorRepository.findDoctorById(doctorId);
        return DoctorMapper.mapDoctorToDoctorDto(doctor);
    }
}
