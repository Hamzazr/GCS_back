package com.example.gcsproject.controller;

import com.example.gcsproject.model.Course;
import com.example.gcsproject.model.Student;
import com.example.gcsproject.repository.CourseRepository;
import com.example.gcsproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository studentRepository;

    @Autowired
    public CourseController(CourseRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Course> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Course createStudent(@RequestBody Course student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Course updateStudent(@PathVariable Long id, @RequestBody Course updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id);
            return studentRepository.save(updatedStudent);
        }
        return null; // Or handle the case where the student with the given ID doesn't exist
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
