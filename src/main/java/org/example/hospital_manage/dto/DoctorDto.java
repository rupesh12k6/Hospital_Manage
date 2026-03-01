package org.example.hospital_manage.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String licenceNumber;
    private String email;
    private Long phone;
    private String availability;



}
