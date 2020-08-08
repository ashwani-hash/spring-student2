/**
 * 
 */
package com.student.service;

import java.util.List;

import com.student.entity.Course;

/**
 * @author Ashwani
 *
 */
public interface CourseService {

	public List<Course> getCourse();

	public void saveCourse(Course course);

	public Course getCourse(int id);

	public void deleteCourse(int id);

}