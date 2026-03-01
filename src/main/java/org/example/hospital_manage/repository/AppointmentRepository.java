package org.example.hospital_manage.repository;

import org.example.hospital_manage.dto.AppointmentDto;
import org.example.hospital_manage.entity.Appointment;
import org.example.hospital_manage.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> getAllByDoctor(Doctor doctor);

    List<Appointment> getAllByAppointmentDate(LocalDateTime appointmentDate);

    List<Appointment> getAllByAppointmentDateBetween(LocalDateTime appointmentDateAfter, LocalDateTime appointmentDateBefore);
}
