package com.task.controller;


import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;
import com.task.entities.Course;
import com.task.entities.Student;
import com.task.repository.CourseRepository;
import com.task.repository.StudentRepository;
import com.task.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {

	@Autowired
	StudentService studentservice;
	@MockBean
	StudentRepository studenRep;
	@MockBean
	CourseRepository courseRep;
	
	@Test
	public void should_GetStudentCourseWithoutExceptions(){
		//given
		Student std = new Student("Abdo","abd@Ahmed.com","Male");
		std.setStudentId(1l);
		Set<Course> courses = new HashSet<Course>();
		courses.add(new Course("DS","Dr.Nabil",10));
		courses.add(new Course("MES","Dr.Manal",15));
		std.setStudentCourses(courses);
		
		when(studenRep.findOne(std.getStudentId())).thenReturn(std);
		
		//when
		Throwable exception = null;
		Set<Course> stdCourses = null;
		try {
		    stdCourses = studentservice.findStdCourses(std.getStudentId());
		} catch (Exception e) {
			exception = e;
		}
		
		//then
		Assertions.assertThat(exception).isNull();
		assertEquals(2, stdCourses.size() );
	}
	
	@Test
	public void should_createStudentWithoutThrowException() {
		//given
		Student std = new Student("Abdalrahman" , "Male" , "abdo@mohamed.com");
		
		//when
		Throwable exception = null;
		try {
			studentservice.createStudent(std);
		} catch (Exception e) {
			exception = e;
		}
		
		//then
		Assertions.assertThat(exception).isNull();
	}

		
	@Test
	public void should_getRegisterCourseWithoutThrowExecption(){
		//given
		Student std = new Student("Abdo","abd@Ahmed.com","Male");
		std.setStudentId(1l);
		Course course = new Course("DS","Dr.Nabil",10);
		course.setCourseId(1l);
		when(courseRep.findOne(course.getCourseId())).thenReturn(course);
		when(studenRep.findOne(std.getStudentId())).thenReturn(std);
		
		//when
		Throwable exception = null;
		try {
			studentservice.registerCourse(course.getCourseId(), std.getStudentId());
		} catch (Exception e) {
			exception = e;
		}
		
		//then
		Assertions.assertThat(exception).isNull();
	}
	
}
