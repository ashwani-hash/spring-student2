/**
 * 
 */
package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dao.CourseDAO;
import com.student.entity.Course;

/**
 * @author Ashwani
 *
 */
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	@Transactional
	public List<Course> getCourse() {
		return courseDAO.getCourse();
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		courseDAO.saveCourse(theCourse);
	}

	@Override
	@Transactional
	public Course getCourse(int theId) {
		return courseDAO.getCourse(theId);
	}

	@Override
	@Transactional
	public void deleteCourse(int theId) {
		courseDAO.deleteCourse(theId);
	}

}
