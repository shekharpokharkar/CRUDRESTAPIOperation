package com.example.demo.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.demo.DTO.StudentDTO;
import com.example.demo.enity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.utils.StudentHelper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public StudentDTO saveStudent(StudentDTO studentDTO) {

		return StudentHelper.map(repository.save(StudentHelper.map(studentDTO)));

	}

	@Override
	public StudentDTO updateStudent(Integer studentId, StudentDTO studentDTO) {

		Student student = repository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException("Student " + studentId + " with given Id is not present"));

		Student studentnew = StudentHelper.map(studentDTO);

		BeanUtils.copyProperties(studentnew, student);

		student.setStudentId(studentId);

		Student student2 = repository.save(student);

		StudentDTO studentDTO3 = StudentHelper.map(student2);

		return studentDTO3;
	}

	@Override
	public StudentDTO deleteStudent(Integer studentId) {

		Student student = repository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException("Student " + studentId + " with given Id is not present"));

		StudentDTO studentDTO3 = StudentHelper.map(student);

		repository.delete(student);

		return studentDTO3;
	}

	@Override
	public List<StudentDTO> getAllStudent() {

		List<StudentDTO> list = repository.findAll().stream().map(StudentHelper::map).toList();

		return list;
	}

	@Override
	public StudentDTO getStudentById(Integer studentId) {

		Student student = repository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException("Student " + studentId + " with given Id is not present"));

		StudentDTO studentDTO3 = StudentHelper.map(student);
		return studentDTO3;
	}

	@Override
	public StudentDTO partialUpdateStudent(Integer studentId, Map<String, Object> studentmap) {

		Student student = repository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException("Student " + studentId + " with given Id is not present"));

		studentmap.forEach((k, v) -> {

			Field field = ReflectionUtils.findField(Student.class, k);
			field.setAccessible(true);
			ReflectionUtils.setField(field, student, v);
		});

		Student save = repository.save(student);
		StudentDTO studentDTO3 = StudentHelper.map(save);
		return studentDTO3;
	}

}
