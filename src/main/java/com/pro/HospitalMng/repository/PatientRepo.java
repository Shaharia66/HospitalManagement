package com.pro.HospitalMng.repository;

import com.pro.HospitalMng.entity.Patient;
import com.pro.HospitalMng.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByName(String name);

    List<Patient>  findByBirthDateOrEmail(LocalDate birthDate, String email);

    @Query("select p from Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroup(@Param("bloodGroop")BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate > ?1")
    List<Patient> findAfterBirthDate(@Param("birthDate")LocalDate birthDate);

    @Query("select p.bloodGroup ,Count(p) from Patient p where p.bloodGroup is not null group by p.bloodGroup")
    List<Object[]> countEachBloodGroup();
    @Query(value = "select * from patient",nativeQuery = true)
    List<Patient> findAllPat();
    @Transactional
    @Modifying
    @Query("update Patient p set p.name=:name where p.id=:id")
    int updateNameById(@Param("name")String name,@Param("id")Long id);

    @Query(value = "select * from patient",nativeQuery = true)
    Page<Patient> findAllPat(Pageable pageable);

}
