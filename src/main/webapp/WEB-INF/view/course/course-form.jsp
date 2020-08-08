
<%@ taglib
	prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<html>
<title>Course</title>
</head>
<body style="text-align: center;">
	<h2 align="center">Add/Edit Course</h2>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<hr />
	<form:form
		action="saveCourse"
		method="post"
		modelAttribute="course">
		<!-- need to associate this data with course id -->
		<form:hidden path="courseId" />
		<div>
			Course Name:
			<form:input
				path="courseName"
				required="required" />
		</div>
		<div>
			<!-- Button -->
			<br />
			<div>
				<form:button>Submit</form:button>
			</div>
		</div>
	</form:form>
</body>
</html>