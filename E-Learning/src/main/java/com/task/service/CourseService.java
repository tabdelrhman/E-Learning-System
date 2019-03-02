package com.task.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Course;
import com.task.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	
	public Course createCourse(Course course) {
		course.setLastupdated(new Date());
		return courseRepository.save(course);
	}


	public Course getCourse(Long courseId) {
		return courseRepository.findOne(courseId);
	}


	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}
}
