package com.project.studentJPAday5.repository;

import com.project.studentJPAday5.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Students,Integer>{
}
