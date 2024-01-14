package com.example.gcsproject.repository;


import com.example.gcsproject.model.Course;
import com.example.gcsproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
