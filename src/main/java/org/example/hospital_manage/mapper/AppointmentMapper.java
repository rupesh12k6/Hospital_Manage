package org.example.hospital_manage.mapper;

import org.example.hospital_manage.dto.AppointmentDto;
import org.example.hospital_manage.entity.Appointment;
import org.example.hospital_manage.service.AppointmentService;
import org.example.hospital_manage.service.DoctorService;
import org.example.hospital_manage.service.PatientService;

public class AppointmentMapper {
    private static DoctorService doctorService;
    private static PatientService patientService;
   public static AppointmentDto maptoAppointmentDto(Appointment appointment){
       return new AppointmentDto(
               appointment.getId(),
              appointment.getAppointmentDate(),
               appointment.getStatus(),
             appointment.getDoctor().getId(),
               appointment.getPatient().getId()

       );
   }
   public static Appointment maptoAppointment(AppointmentDto appointmentDto){
       return new Appointment(
               appointmentDto.getId(),
               appointmentDto.getAppointmentDate(),
               appointmentDto.getStatus(),
              DoctorMapper.mapDoctorDtoToDoctor(doctorService.getDoctorById(appointmentDto.getDoctorId())),
              PatientMapper.mapToPatient( patientService.getPatientById(appointmentDto.getPatientId()))
       );
   }
}
