package com.task.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.Course;
import com.task.entities.Student;
import com.task.service.StudentService;

@RestController
@RequestMapping("/e-learning")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	private static final Logger LOG = Logger.getLogger(CourseController.class);
	
	
	@PostMapping("/student")
	public Student createStudent(@Valid @RequestBody Student std) {
		LOG.info("Calling: /e-learning/student - createStudent - POST service");
			return studentService.createStudent(std);
		
	}
	
	@PostMapping("/student/course/{courseId}/{studentId}")
	public void addCourse(@PathVariable(value="courseId") Long courseId , @PathVariable(value="studentId") Long studentId) {
		LOG.info("Calling: /e-learning/studentcourse/{courseId}/{studentId} - addCourse - POST service");
		studentService.registerCourse(courseId,studentId);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="studentId") Long stdId){
		LOG.info("Calling: /e-learning/student/{studentId} - getStudentById - GET service");
		Student std=studentService.getStudent(stdId);
		
		if(std==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(std);
		
	}
	
	@GetMapping("/student/courses/{studentId}")
	public Set<Course> getStudentCourses(@PathVariable(value="studentId") Long stdId){
		LOG.info("Calling: /e-learning/student/courses/{studentId} - getStudentCourses - GET service");
		Set<Course> stdCourses = new HashSet<Course>();
		stdCourses = studentService.findStdCourses(stdId);
		return stdCourses;
	}
	
	@DeleteMapping("/student/course/{courseId}/{studentId}")
	public void unregisterCourse(@PathVariable(value="courseId") Long courseId, @PathVariable(value="studentId") Long studentId){
		LOG.info("Calling: /e-learning/course/{courseId}/{studentId} - unregisterCourse - DELETE service");
		studentService.unregisterCourse(courseId,studentId);
		
		
	}
	
	
	
	
}
