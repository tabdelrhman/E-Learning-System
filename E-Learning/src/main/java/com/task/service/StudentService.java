package com.task.service;

import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Course;
import com.task.entities.Student;
import com.task.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseService courseService;

	public Student createStudent(Student std) {
		String validate = validateReq(std);
		if (validate.isEmpty()) {
			return studentRepository.save(std);
		}
		throw new IllegalArgumentException("Error .. Arguments are not correct! "
				+ validate.replace(validate.charAt(validate.lastIndexOf('-')), '.')); // this is to replace last '-' with '.'
		}

	public void registerCourse(Long courseId, Long studentId) {
		Course course = null;
		Student student = null;
		try {
			course = courseService.getCourse(courseId);
			student = studentRepository.findOne(studentId);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Error .. There is no student with this id.");
		}
		if (course != null && student != null) {
			student.getStudentCourses().add(course);
			studentRepository.save(student);
		}
	}

	public Student getStudent(Long stdId) {
		return studentRepository.findOne(stdId);
	}

	public Set<Course> findStdCourses(Long stdId) {
		Student student = studentRepository.findOne(stdId);
		if (student == null) {
			throw new EntityNotFoundException("Error .. There is no student with this id.");
		}
		return student.getStudentCourses();
	}

	public void unregisterCourse(Long courseId, Long studentId) {
		Student student = getStudent(studentId);
		Course course = courseService.getCourse(courseId);
		if (student == null) {
			throw new EntityNotFoundException("Error .. There is no student with this id.");
		}
		if (student.getStudentCourses().contains(course)) {
			student.getStudentCourses().remove(course);
		} else {
			throw new EntityNotFoundException("Error .. This Course is not assigned to that student");
		}

		studentRepository.save(student);
	}

	private String validateReq(Student std) {
		StringBuilder err = new StringBuilder("");
		if (std.getName() == null) {
			err.append(" Name shouldn't be null- ");
		} else if (!std.getEmail().contains("@")) {
			err.append(" please enter a valid email- ");
		} else if (std.getGender() == null) {
			err.append(" Gender shouldn't be null-");
		}

		return err.toString();

	}

}
