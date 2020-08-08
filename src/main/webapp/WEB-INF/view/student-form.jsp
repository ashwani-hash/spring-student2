
<%@ taglib
	prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<html>
<title>Student</title>
</head>
<body style="text-align: center;">
	<h2 align="center">Add/Edit Student</h2>
	<a href="${pageContext.request.contextPath}/">Home</a>
	<hr />
	<form:form
		action="saveStudent"
		method="post"
		modelAttribute="student">
		<!-- need to associate this data with student id -->
		<form:hidden path="studentId" />
		<div>
			First Name:
			<form:input
				path="firstName"
				required="required" />
		</div>
		<div>
			<br />Last Name:
			<form:input path="lastName" />
		</div>
		<div>
			<br />Phone:
			<form:input path="phone" />
		</div>
		<div>
			<br />Email:
			<form:input path="email" />
		</div>
		<div>
			<br />Course:
			<form:input path="commaSeparatedCourse" />
		</div>
		<div>
			<br />
			<form:button>Submit</form:button>
		</div>
	</form:form>
</body>
</html>