package com.example.gcsproject.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class GroupCourse {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;


	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="teacherId", nullable=false)
	private Teacher teacher;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="courseId", nullable=false)
	private Course course;


	@ManyToMany
	@JoinTable(
			name = "group_student",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "group_id"))
	 private Set<Student> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
