package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.DTO.StudentDTO;

public interface StudentService {

	public StudentDTO saveStudent(StudentDTO studentDTO);

	public StudentDTO updateStudent(Integer studentId, StudentDTO studentDTO);

	public StudentDTO deleteStudent(Integer studentId);

	public StudentDTO partialUpdateStudent(Integer studentId, Map<String, Object> student);

	public List<StudentDTO> getAllStudent();

	public StudentDTO getStudentById(Integer studentId);

}
