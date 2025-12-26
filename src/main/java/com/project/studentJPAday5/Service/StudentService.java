package com.project.studentJPAday5.Service;

import com.project.studentJPAday5.DTO.StudentRequestDTO;
import com.project.studentJPAday5.DTO.StudentResponseDTO;
import com.project.studentJPAday5.Exception.StudentNotFoundException;
import com.project.studentJPAday5.entity.Students;
import com.project.studentJPAday5.repository.StudentRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentService {
    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public Page<StudentResponseDTO> getAllStudents(int page, int size, String sort) {
        Sort sortFactor = Sort.by(sort).ascending();
        Pageable pageable= PageRequest.of(page,size,sortFactor);
        Page<Students>allStudents=repo.findAll(pageable);
        return allStudents.map(this::mapToDTO);
    }

    public StudentResponseDTO getAllStudentsById(int id) {
        System.out.println("✨✨✨");
        Students Stud=repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not Found with this id"));
        return mapToDTO(Stud);
    }

    public StudentResponseDTO addStudents(StudentRequestDTO Student) {
        Students entity= mapToEntity(Student);
        Students s = repo.save(entity);
        return mapToDTO(s);
    }

    public StudentResponseDTO updateStudent(int id, Students newData) {
        Students existingStudent = repo.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with id does not exists"));
        if (existingStudent == null) {
            return null;
        }
        existingStudent.setEmail(newData.getEmail());
        existingStudent.setName(newData.getName());

        Students updatedStudent= repo.save(existingStudent);
        return mapToDTO(updatedStudent);
    }

    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student not Found");
        }
        repo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student added successfully with ID: " + id);
    }

    //Get Student By Email
    public StudentResponseDTO getStudentByEmail(String email){
        Students student=repo.findByEmail(email).orElseThrow(()->new StudentNotFoundException("Student with this email has not found"));
        return mapToDTO(student);
    }
    //Get Student By name
    public StudentResponseDTO getStudentByName(String name){
        Students student= repo.findByName(name).orElseThrow(()->new StudentNotFoundException("Student with this name has not found"));;
        return  mapToDTO(student);
    }
    private Students mapToEntity(StudentRequestDTO Student) {
        Students studEntity = new Students();
        studEntity.setName(Student.getName());
        studEntity.setEmail(Student.getEmail());
        studEntity.setPassword(Student.getPassword());
        return studEntity;
    }

    private StudentResponseDTO mapToDTO(Students Student){
        StudentResponseDTO studResDTO= new StudentResponseDTO();
        studResDTO.setId(Student.getId());
        studResDTO.setName(Student.getName());
        studResDTO.setEmail(Student.getEmail());
        return studResDTO;
    }
}