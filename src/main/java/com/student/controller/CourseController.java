/**
 * 
 */
package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.entity.Course;
import com.student.service.CourseService;

/**
 * @author Ashwani
 *
 */
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public String listCourses(Model theModel) {
		List<Course> theCourses = courseService.getCourse();
		theModel.addAttribute("courses", theCourses);
		return "course/course-list";
	}

	@GetMapping("/addCourse")
	public String showFormForAdd(Model theModel) {
		Course course = new Course();
		theModel.addAttribute("course", course);
		return "course/course-form";
	}

	@PostMapping("/saveCourse")
	public String saveCourse(@ModelAttribute("course") Course course) {
		courseService.saveCourse(course);
		return "redirect:/courses";
	}

	@GetMapping("/updateCourse")
	public String showFormForUpdate(@RequestParam("courseId") int courseId, Model theModel) {
		Course course = courseService.getCourse(courseId);
		theModel.addAttribute("course", course);
		return "course/course-form";
	}

	@GetMapping("/deleteCourse")
	public String deleteCourse(@RequestParam("courseId") int courseId) {
		courseService.deleteCourse(courseId);
		return "redirect:/courses";
	}

}
