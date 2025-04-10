package com.example.demo.enity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String studentName;
	private Double studentPercentage;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate studentDateOfBirth;
	private Character studentGender;
	private BigDecimal studentSalary;
	private boolean isMarried;

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Double getStudentPercentage() {
		return studentPercentage;
	}

	public void setStudentPercentage(Double studentPercentage) {
		this.studentPercentage = studentPercentage;
	}

	public LocalDate getStudentDateOfBirth() {
		return studentDateOfBirth;
	}

	public void setStudentDateOfBirth(LocalDate studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}

	public Character getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(Character studentGender) {
		this.studentGender = studentGender;
	}

	public BigDecimal getStudentSalary() {
		return studentSalary;
	}

	public void setStudentSalary(BigDecimal studentSalary) {
		this.studentSalary = studentSalary;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentPercentage="
				+ studentPercentage + ", studentDateOfBirth=" + studentDateOfBirth + ", studentGender=" + studentGender
				+ ", studentSalary=" + studentSalary + ", isMarried=" + isMarried + "]";
	}

}
