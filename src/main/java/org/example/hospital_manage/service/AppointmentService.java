package org.example.hospital_manage.service;

import lombok.AllArgsConstructor;
import org.example.hospital_manage.dto.AppointmentDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);
    AppointmentDto updateAppointmentById(Long Id,AppointmentDto appointmentDto);
    void deleteAppointment(Long id);
    AppointmentDto getAppointmentById(Long id);
    List<AppointmentDto> getAllAppointmentsByDoctorId(Long id);
    List<AppointmentDto> getAllAppointmentsByDate(LocalDate date);
    List<AppointmentDto> getAllAppointmentsByPatientId(Long id);
}
