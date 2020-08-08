
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<html>
<title>Student</title>
</head>
<body style="text-align: center;">
	<h2 align="center">Courses</h2>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<hr />
	<a href="${pageContext.request.contextPath}/addCourse">Add Course</a>
	<br />
	<br />
	<table style="border: 1px solid; margin: 0px auto;">
		<tr>
			<th style="border: 1px solid;">Id</th>
			<th style="border: 1px solid;">Course Name</th>
			<th style="border: 1px solid;">Action</th>
		</tr>
		<!-- loop over and print our students -->
		<c:forEach
			var="course"
			items="${courses}">
			<c:url
				var="updateLink"
				value="/updateCourse">
				<c:param
					name="courseId"
					value="${course.courseId}" />
			</c:url>
			<c:url
				var="deleteLink"
				value="/deleteCourse">
				<c:param
					name="courseId"
					value="${course.courseId}" />
			</c:url>
			<tr>
				<td style="border: 1px solid;">${course.courseId}</td>
				<td style="border: 1px solid;">${course.courseName}</td>
				<td style="border: 1px solid;">
					<!-- display the update link --> <a href="${updateLink}">Update</a> | <a
						href="${deleteLink}"
						onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>