package com.example.gcsproject.controller;

import com.example.gcsproject.model.Student;
import com.example.gcsproject.model.Teacher;
import com.example.gcsproject.repository.StudentRepository;
import com.example.gcsproject.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    // Get all students
    @GetMapping
    public List<Teacher> getAllStudents() {
        return teacherRepository.findAll();
    }

    // Get a specific student by ID
    @GetMapping("/{id}")
    public Teacher getStudentById(@PathVariable Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    // Create a new student
    @PostMapping
    public Teacher createStudent(@RequestBody Teacher student) {
        return teacherRepository.save(student);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public Teacher updateStudent(@PathVariable Long id, @RequestBody Teacher updatedStudent) {
        if (teacherRepository.existsById(id)) {
            updatedStudent.setId(id);
            return teacherRepository.save(updatedStudent);
        }
        return null;
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }
}
