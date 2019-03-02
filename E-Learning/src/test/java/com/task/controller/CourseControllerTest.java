package com.task.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.task.entities.Course;
import com.task.repository.CourseRepository;
import com.task.service.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseControllerTest {

	@Autowired
	CourseService courseService;
	@MockBean
	CourseRepository courseRep;
	
	@Test
	public void should_GetAllCoursesWithoutExceptions(){
		//given
		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("DS","Dr.Nabil",10));
		courses.add(new Course("MES","Dr.Manal",15));
		
		when(courseRep.findAll()).thenReturn(courses);
		
		//when
		Throwable exception = null;
		List<Course> AllCourses = null;
		try {
			AllCourses = courseService.findAllCourses();
		} catch (Exception e) {
			exception = e;
		}
		
		//then
		Assertions.assertThat(exception).isNull();
		assertEquals(2, AllCourses.size() );
	}
	
	@Test
	public void should_createStudentWithoutThrowException() {
		//given
		Course course = new Course("DS","Dr.Nabil",10);
		
		//when
		Throwable exception = null;
		try {
			courseService.createCourse(course);
		} catch (Exception e) {
			exception = e;
		}
		
		//then
		Assertions.assertThat(exception).isNull();
	}


	
}
