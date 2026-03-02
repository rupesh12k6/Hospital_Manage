package org.example.hospital_manage.service.impl;

import lombok.AllArgsConstructor;
import org.example.hospital_manage.dto.AppointmentDto;
import org.example.hospital_manage.entity.Appointment;
import org.example.hospital_manage.entity.Doctor;
import org.example.hospital_manage.entity.Patient;
import org.example.hospital_manage.exception.ResourceNotFoundException;
import org.example.hospital_manage.mapper.AppointmentMapper;
import org.example.hospital_manage.mapper.DoctorMapper;
import org.example.hospital_manage.mapper.PatientMapper;
import org.example.hospital_manage.repository.AppointmentRepository;
import org.example.hospital_manage.repository.DoctorRepository;
import org.example.hospital_manage.service.AppointmentService;
import org.example.hospital_manage.service.DoctorService;
import org.example.hospital_manage.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository appointmentRepository;
    DoctorRepository doctorRepository;
    PatientService patientService;
    DoctorService doctorService;
    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        appointmentRepository.save(AppointmentMapper.maptoAppointment(appointmentDto));
        return appointmentDto;
      }



    @Override
    public AppointmentDto updateAppointmentById(Long Id, AppointmentDto appointmentDto) {
        Appointment updatedAppointment=appointmentRepository.findById(Id).get();
        updatedAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        updatedAppointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        updatedAppointment.setStatus(appointmentDto.getStatus());
        updatedAppointment.setPatient(PatientMapper.mapToPatient(patientService.getPatientById(appointmentDto.getId())));
        updatedAppointment.setDoctor(DoctorMapper.mapDoctorDtoToDoctor(doctorService.getDoctorById(appointmentDto.getId())));
        return AppointmentMapper.maptoAppointmentDto(appointmentRepository.save(updatedAppointment));

    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
       return  AppointmentMapper.maptoAppointmentDto(appointmentRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Appointment is not found with id:"+id)));
    }

    @Override
    public List<AppointmentDto> getAllAppointmentsByDoctorId(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment is not found with id:"+id));
        List<Appointment> appointments=appointmentRepository.getAllByDoctor(doctor);
        return appointments.stream().map(AppointmentMapper::maptoAppointmentDto).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDto> getAllAppointmentsByDate(LocalDate date) {
        LocalDateTime startOfDay=date.atStartOfDay();
       LocalDateTime endOfDay=date.atTime(LocalTime.MAX);
        List<Appointment> appointments=appointmentRepository.getAllByAppointmentDateBetween(startOfDay,endOfDay);
        return appointments.stream().map((AppointmentMapper::maptoAppointmentDto)).collect(Collectors.toList());

    }

    @Override
    public List<AppointmentDto> getAllAppointmentsByPatientId(Long id) {
        Patient patient=PatientMapper.mapToPatient(patientService.getPatientById(id));
        List<Appointment> appointments=appointmentRepository.getAllByPatient(patient);
        return appointments.stream().map((AppointmentMapper::maptoAppointmentDto)).collect(Collectors.toList());
    }
}
