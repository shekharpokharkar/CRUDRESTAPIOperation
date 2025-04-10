package com.example.demo.utils;

import org.springframework.beans.BeanUtils;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.enity.Student;

public interface StudentHelper {

	public static Student map(StudentDTO studentdto) {

		Student student = new Student();
		BeanUtils.copyProperties(studentdto, student);

		return student;

	}

	public static StudentDTO map(Student student) {

		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(student, dto);
		return dto;

	}
}
