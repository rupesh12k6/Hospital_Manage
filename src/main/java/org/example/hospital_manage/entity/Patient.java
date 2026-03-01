package org.example.hospital_manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;


    @Min(value = 6000000000L, message = "Invalid mobile number")
    @Max(value = 9999999999L, message = "Invalid mobile number")
    @Column( nullable = false)
    private Long number;



    @Min(value = 200000000000L, message = "Aadhaar must be 12 digits starting with 2-9")
    @Max(value = 999999999999L, message = "Aadhaar must be 12 digits")
    @Column( unique = true, nullable = false)
    private Long aadhaar;

    @Email(message = "Enter a valid email")
    @Column(nullable=true)
    private String email;

   @NotNull
    @Pattern(regexp = "^(MALE|FEMALE|OTHER)$", message = "Gender must be MALE, FEMALE, or OTHER")
    @Column( nullable = false, length = 10)
    private String Gender;

    @Min(value = 0,message = "Enter a valid age")
    @Max(value = 110,message = "Enter a Valid Age")
    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
}
