package org.example.hospital_manage.mapper;

import org.example.hospital_manage.dto.AppointmentDto;
import org.example.hospital_manage.entity.Appointment;

public class AppointmentMapper {
   public static AppointmentDto maptoAppointmentDto(Appointment appointment){
       return new AppointmentDto(
               appointment.getId(),
              appointment.getAppointmentDate(),
               appointment.getStatus(),
             DoctorMapper.mapDoctorToDoctorDto(appointment.getDoctor()),
               PatientMapper.mapToPatientDto(appointment.getPatient())

       );
   }
   public static Appointment maptoAppointment(AppointmentDto appointmentDto){
       return new Appointment(
               appointmentDto.getId(),
               appointmentDto.getAppointmentDate(),
               appointmentDto.getStatus(),
              DoctorMapper.mapDoctorDtoToDoctor( appointmentDto.getDoctorDto()),
              PatientMapper.mapToPatient( appointmentDto.getPatientDto())
       );
   }
}
