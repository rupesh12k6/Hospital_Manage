package org.example.hospital_manage.repository;

import org.example.hospital_manage.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
