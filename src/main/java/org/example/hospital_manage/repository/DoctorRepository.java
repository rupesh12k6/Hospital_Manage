package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.Doctor;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Doctor findByLicenceNumber(String licenceNumber);

    Doctor findDoctorById(Long id);

    List<Doctor> findAllBySpecialization(String specialization);
}
