package com.example.gcsproject.repository;


import com.example.gcsproject.model.Student;
import com.example.gcsproject.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
