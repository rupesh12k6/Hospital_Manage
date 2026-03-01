package org.example.hospital_manage.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.hospital_manage.dto.AppointmentDto;
import org.example.hospital_manage.dto.DoctorDto;
import org.example.hospital_manage.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/apppointments")
public class AppointmentController {
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody @Valid AppointmentDto appointmentDto) {
        if(appointmentDto.getDoctorDto().getAvailability().equals("Avaialable")) {

            AppointmentDto savedAppointment = appointmentService.createAppointment(appointmentDto);
            return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable long id) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/{date}")
    public ResponseEntity<String> deleteAppointmentByIdDate(@PathVariable Long id, @PathVariable LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isEqual(date)) {
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.badRequest().body("History Date Appointments cannot be deleted");
        }
    }

    @GetMapping("doctor/{id}")
    public ResponseEntity<List<AppointmentDto>> getDoctorAppointmentById(@PathVariable Long id) {
        List<AppointmentDto> appointmentDtoList=appointmentService.getAllAppointmentsByDoctorId(id);
        return new ResponseEntity<>(appointmentDtoList, HttpStatus.OK);
    }
    @GetMapping("date/{date}")
    public ResponseEntity<List<AppointmentDto>> getAllAppointmentsByDate(@PathVariable LocalDate date) {
        List<AppointmentDto> appointmentDtoList=appointmentService.getAllAppointmentsByDate(date);
        return new ResponseEntity<>(appointmentDtoList, HttpStatus.OK);
    }
}

