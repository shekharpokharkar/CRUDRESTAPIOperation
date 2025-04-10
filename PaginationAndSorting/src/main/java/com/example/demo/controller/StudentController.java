package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO DTO) {

		StudentDTO saveStudent = service.saveStudent(DTO);

		return new ResponseEntity<StudentDTO>(saveStudent, HttpStatus.CREATED);

	}

	@GetMapping("/student")
	public ResponseEntity<List<StudentDTO>> getAllStudent() {

		List<StudentDTO> saveStudent = service.getAllStudent();

		return new ResponseEntity<List<StudentDTO>>(saveStudent, HttpStatus.OK);

	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable("studentId") Integer studentId) {

		StudentDTO studentById = service.getStudentById(studentId);

		return new ResponseEntity<StudentDTO>(studentById, HttpStatus.OK);

	}

	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<StudentDTO> deleteStudentById(@PathVariable("studentId") Integer studentId) {

		StudentDTO studentById = service.deleteStudent(studentId);

		return new ResponseEntity<StudentDTO>(studentById, HttpStatus.OK);

	}

	@PutMapping("/student/{studentId}")
	public ResponseEntity<StudentDTO> addStudent(@PathVariable("studentId") Integer studentId,
			@RequestBody StudentDTO DTO) {

		StudentDTO saveStudent = service.updateStudent(studentId, DTO);

		return new ResponseEntity<StudentDTO>(saveStudent, HttpStatus.ACCEPTED);

	}

	@PatchMapping("/student/{studentId}")
	public ResponseEntity<StudentDTO> partialUpdateStudent(@PathVariable("studentId") Integer studentId,
			@RequestBody Map<String, Object> stu) {

		StudentDTO saveStudent = service.partialUpdateStudent(studentId, stu);

		return new ResponseEntity<StudentDTO>(saveStudent, HttpStatus.ACCEPTED);

	}

}
