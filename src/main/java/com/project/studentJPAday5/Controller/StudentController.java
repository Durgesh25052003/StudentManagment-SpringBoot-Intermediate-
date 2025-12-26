package com.project.studentJPAday5.Controller;

import com.project.studentJPAday5.DTO.StudentRequestDTO;
import com.project.studentJPAday5.DTO.StudentResponseDTO;
import com.project.studentJPAday5.DTOWrapper.ApiResponse;
import com.project.studentJPAday5.Service.StudentService;
import com.project.studentJPAday5.entity.Students;
import com.project.studentJPAday5.repository.StudentRepo;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService Service;

    public StudentController(StudentService service){
        this.Service=service;
    }

    @GetMapping
    public Page<StudentResponseDTO> getAllStudents(@RequestParam int page, @RequestParam int size,@RequestParam String sort){
        return Service.getAllStudents(page,size,sort);
    }

    @PostMapping
    public StudentResponseDTO addStudent(@Valid @RequestBody StudentRequestDTO s){
        return Service.addStudents(s);
    }

    @GetMapping("/id/{id}")
    public StudentResponseDTO getStudentById(@PathVariable int id){
        return Service.getAllStudentsById(id);
    }
    @GetMapping("/email/{email}")
    public StudentResponseDTO getStudentByEmail(@PathVariable String email){
        return Service.getStudentByEmail(email);
    }
    @GetMapping("/name/{name}")
    public StudentResponseDTO getStudentByName(@PathVariable String name){
        return Service.getStudentByName(name);
    }
    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable int id,@RequestBody Students newData){
        return Service.updateStudent(id,newData);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
       return Service.deleteStudent(id);
    }
}
