/**
 * 
 */
package com.student.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.entity.Course;
import com.student.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents(int pageNumber) {
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("From Student order by studentId", Student.class);
		query.setFirstResult((pageNumber - 1) * 10);
		query.setMaxResults(10);

		List<Student> students = query.getResultList();
		return students;

	}

	@Override
	public Long getCount() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder qb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(Student.class)));
		return session.createQuery(cq).getSingleResult();
	}

	@Override
	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.byId(Student.class).load(id);
		session.delete(student);
	}

	@Override
	public void saveStudent(Student theStudent) {
		Session currentSession = sessionFactory.getCurrentSession();
		if (theStudent.getCourses().size() > 0) {

			for (Course course : theStudent.getCourses()) {
				currentSession.saveOrUpdate(course);
			}

		}
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public Student getStudent(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, theId);
		return student;
	}
}