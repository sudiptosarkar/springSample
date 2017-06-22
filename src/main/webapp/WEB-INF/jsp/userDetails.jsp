<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

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
	<h2>User Details:</h2>
	<table>
		<tr>
			<td>Username:</td>
			<td>${user.username}</td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${user.lastName}</td>
		</tr>
		<tr>
			<td>Phone number:</td>
			<td>${user.phoneNumber}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${user.email}</td>
		</tr>
	</table>
</body>

</html>
