package com.project.studentJPAday5.Controller;

import com.project.studentJPAday5.entity.Students;
import com.project.studentJPAday5.repository.StudentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepo repo;

    public StudentController(StudentRepo repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Students> getAllStudents(){
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Students s){
        Students saved=repo.save(s);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully with ID: " + saved.getId());
    }

    @GetMapping("/{id}")
    public Students getStudentById(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }
}
