/**
 * 
 */
package com.student.dao;

import java.util.List;

import com.student.entity.Student;

/**
 * @author Ashwani
 *
 */
public interface StudentDAO {

	public List<Student> getStudents(int pageNumber);

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

	Long getCount();
}