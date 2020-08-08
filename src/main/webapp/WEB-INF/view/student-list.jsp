
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<html>
<title>Student</title>
</head>
<body style="text-align: center;">
	<h2 align="center">Student Management System</h2>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<hr />
	<a href="${pageContext.request.contextPath}/addStudent">Add Student</a>
	<br />
	<a href="${pageContext.request.contextPath}/courses">Course</a>
	<br />
	<br />
	<table style="border: 1px solid; margin: 0px auto;">
		<tr>
			<th style="border: 1px solid;">Id</th>
			<th style="border: 1px solid;">First Name</th>
			<th style="border: 1px solid;">Last Name</th>
			<th style="border: 1px solid;">Phone</th>
			<th style="border: 1px solid;">Email</th>
			<th style="border: 1px solid;">Action</th>
		</tr>
		<!-- loop over and print our students -->
		<c:forEach
			var="student"
			items="${students}">
			<c:url
				var="updateLink"
				value="/editStudent">
				<c:param
					name="studentId"
					value="${student.studentId}" />
			</c:url>
			<c:url
				var="deleteLink"
				value="/deleteStudent">
				<c:param
					name="studentId"
					value="${student.studentId}" />
			</c:url>
			<tr>
				<td style="border: 1px solid;">${student.studentId}</td>
				<td style="border: 1px solid;"><a href="${pageContext.request.contextPath}/viewStudentDetails/${student.studentId}">${student.firstName}</a></td>
				<td style="border: 1px solid;">${student.lastName}</td>
				<td style="border: 1px solid;">${student.phone}</td>
				<td style="border: 1px solid;">${student.email}</td>
				<td style="border: 1px solid;">
					<!-- display the update link --> <a href="${updateLink}">Update</a> | <a
						href="${deleteLink}"
						onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br /> Go to:
	<c:forEach
		var="page"
		items="${pages}">
		<a href="${pageContext.request.contextPath}/${page}">${page}</a>&nbsp;
	</c:forEach>
</body>
</html>