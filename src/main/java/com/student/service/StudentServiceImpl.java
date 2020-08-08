/**
 * 
 */
package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.StudentDAO;
import com.student.entity.Student;

/**
 * @author Ashwani
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	@Transactional
	public List<Student> getStudents(int pageNumber) {
		return studentDAO.getStudents(pageNumber);
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Override
	@Transactional
	public void deleteStudent(int studentId) {
		studentDAO.deleteStudent(studentId);
	}

	@Override
	@Transactional
	public Student getStudentDetails(int studentId) {
		return studentDAO.getStudent(studentId);
	}

	@Override
	@Transactional
	public Long getCount() {
		return studentDAO.getCount();
	}

}
