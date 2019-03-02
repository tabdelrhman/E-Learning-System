package com.task.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.task.entities.Course;
import com.task.service.CourseService;

@RestController
@RequestMapping("/e-learning")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	private static final Logger LOG = Logger.getLogger(CourseController.class);
	
	
	@PostMapping("/course")
	public Course createCourse(@Valid @RequestBody Course course) {
		LOG.info("Calling: /e-learning/course - createCourse - POST service");
		return courseService.createCourse(course);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable(value="id") Long courseId){
		LOG.info("Calling: /e-learning/course/{id} - getCourseById - GET service");
		Course course=courseService.getCourse(courseId);
		
		if(course==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(course);
	}
	
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		LOG.info("Calling: /e-learning/course/ - getAllCourses - GET service");
		List<Course> Courses = new ArrayList<Course>();
		Courses = courseService.findAllCourses();
		return Courses;
	}
}
