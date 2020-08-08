DROP TABLE IF EXISTS student_course;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS student;

CREATE TABLE student
(
  student_id Serial PRIMARY KEY,
  first_name character varying(200),
  last_name character varying(200),
  phone character varying(20),
  email character varying(200)
);
create TABLE course
(
  course_id Serial PRIMARY KEY,  
  course_name character varying(200)
);

CREATE TABLE student_course (
  course_id Serial REFERENCES course(course_id),
  student_id Serial REFERENCES student(student_id) 
);