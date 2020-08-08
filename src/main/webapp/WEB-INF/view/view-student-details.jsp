
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<html>
<title>Student details</title>
</head>
<body style="text-align: center;">
	<h2 align="center">Student details</h2>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<hr />
	Name: ${student.firstName} ${student.firstName}
	<br /> Phone: ${student.phone}
	<br /> Email: ${student.email}
	<br />
	<br />
	<b>Courses</b>
	<br />
	<c:forEach
		var="course"
		items="${student.courses}">
		${course.courseName}<br />
	</c:forEach>
</body>
</html>