/**
 * 
 */
package com.student.service;

import java.util.List;

import com.student.entity.Student;

/**
 * @author Ashwani
 *
 */
public interface StudentService {

	public List<Student> getStudents(int pageNumber);

	public void saveStudent(Student student);

	public Student getStudent(int studentId);

	public void deleteStudent(int studentId);

	public Student getStudentDetails(int studentId);
	
	Long getCount();


}