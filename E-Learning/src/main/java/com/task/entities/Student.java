package com.task.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="student" )
@EntityListeners(AuditingEntityListener.class)
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_courses", joinColumns = { @JoinColumn(name = "studentId") }, inverseJoinColumns = {
            @JoinColumn(name = "courseId") })
    private Set<Course> studentCourses;

	public Student(){}
	
	public Student(String name, String gender, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.studentCourses = new HashSet<Course>();
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStudentCourses(Set<Course> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public Set<Course> getStudentCourses() {
		return studentCourses;
	}

	
	}
