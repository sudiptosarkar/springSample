<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<form id="logoutForm" action="/logout">
		<table class="headerBar">
			<tr>
				<td><a href="/listUsers">HOME</a></td>
				<td style="text-align: right">${pageContext.request.userPrincipal.name}
					| <a href="#"
					onclick="document.getElementById('logoutForm').submit()">Logout</a>&nbsp;&nbsp;&nbsp;
				</td>
			<tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<h2>Add new User:</h2>
	<form:form method="POST" commandName="user" action="addUser">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>FirstName</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Phone number:</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
		</table>
		<form:button>Submit</form:button>
	</form:form>
</body>

</html>
