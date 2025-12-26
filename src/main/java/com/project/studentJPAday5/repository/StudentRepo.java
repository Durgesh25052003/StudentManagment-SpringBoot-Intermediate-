package com.project.studentJPAday5.repository;

import com.project.studentJPAday5.DTO.StudentResponseDTO;
import com.project.studentJPAday5.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Students,Integer>{

    @Query("Select s from Students s where s.email = :email")
    Optional<Students> findByEmail(@Param("email") String email);

    @Query("Select s from Students s where s.name = :name")
    Optional<Students> findByName(@Param("name") String name);
}
