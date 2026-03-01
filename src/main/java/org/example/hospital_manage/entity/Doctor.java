package org.example.hospital_manage.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Nonnull
    @Column
    private String specialization;
    @NonNull
    @Column
    private String licenceNumber;

    @Email(message = "Enter the valid e-mail")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Phone number is required")
    @Min(value = 6000000000L, message = "Invalid mobile number")
    @Max(value = 9999999999L, message = "Invalid mobile number")
    @Column(nullable = false)
    private Long phone;
    @NotNull
    @Pattern(regexp = "^(Available|Not-Available)")
    private String availability;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;


}
