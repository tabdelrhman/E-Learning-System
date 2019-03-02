package com.task.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="course" )
@EntityListeners(AuditingEntityListener.class)
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseId;
	
	@NotBlank
	private String courseName;
	
	private String description;
	
	@NotBlank
	private String instructor;
	
	private int total_hours;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastupdated;
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentCourses")
	private Set<Student> students;


	public Course(){}
	
	public Course(String courseName, String instructor, int total_hours) {
		super();
		this.courseName = courseName;
		this.instructor = instructor;
		this.total_hours = total_hours;
	}


	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getInstructor() {
		return instructor;
	}


	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}


	public int getTotal_hours() {
		return total_hours;
	}


	public void setTotal_hours(int total_hours) {
		this.total_hours = total_hours;
	}


	public Date getPublishDate() {
		return publishDate;
	}


	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}


	public Date getLastupdated() {
		return lastupdated;
	}


	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
	}
