/**
 * 
 */
package com.student.dao;

import java.util.List;

import com.student.entity.Course;

/**
 * @author Ashwani
 *
 */
public interface CourseDAO {

	public List<Course> getCourse();

	public void saveCourse(Course course);

	public Course getCourse(int theId);

	public void deleteCourse(int theId);
}