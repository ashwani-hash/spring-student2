/**
 * 
 */
package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.entity.Course;
import com.student.entity.Student;
import com.student.service.StudentService;

/**
 * @author Ashwani
 *
 */
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public String listStudents(Model model) {
		return getDataAndPaginate(model, 0);
	}

	@GetMapping("/{page}")
	public String listStudents(@PathVariable("page") int pageNumber, Model model) {
		return getDataAndPaginate(model, pageNumber);
	}

	private String getDataAndPaginate(Model model, int pageNumber) {
		List<Student> students = studentService.getStudents(pageNumber);
		long count = studentService.getCount();

		List<Integer> pages = new ArrayList<Integer>();
		if (count > 10) {
			for (int i = 0; i <= count / 10; i++) {
				pages.add(i + 1);
			}
		}
		model.addAttribute("students", students);
		model.addAttribute("pages", pages);
		return "student-list";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {

		if (!student.getCommaSeparatedCourse().isEmpty()) {
			String[] str = student.getCommaSeparatedCourse().split(" ");
			List<Course> courses = new ArrayList<Course>();
			for (String string : str) {
				Course course = new Course();
				course.setCourseName(string);
				courses.add(course);
			}

			student.setCourses(courses);
		}

		studentService.saveStudent(student);
		return "redirect:/";
	}

	@GetMapping("/editStudent")
	public String editStudent(@RequestParam("studentId") int studentId, Model model) {
		Student student = studentService.getStudent(studentId);
		model.addAttribute("student", student);
		return "student-form";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/";
	}

	@GetMapping("/viewStudentDetails/{studentId}")
	public String viewStudentDetails(@PathVariable("studentId") int studentId, Model model) {
		Student student = studentService.getStudentDetails(studentId);
		model.addAttribute("student", student);
		return "view-student-details";
	}
}