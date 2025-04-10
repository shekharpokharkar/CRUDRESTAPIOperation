package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByStudentNameOrStudentGender(String studentName, Character gender);

	public List<Student> findByStudentDateOfBirthGreaterThanEqual(LocalDate date);
	
	public List<Student> findByIsMarriedFalse();
	
	
	
	


}
