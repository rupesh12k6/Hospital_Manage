package org.example.hospital_manage.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long number;
    private Long aadhaar;
    private String email;
    private String Gender;
    private Integer age;

}
