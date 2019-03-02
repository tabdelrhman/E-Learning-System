package com.task.repository;

import com.task.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends	 JpaRepository<Student, Long> {

}
