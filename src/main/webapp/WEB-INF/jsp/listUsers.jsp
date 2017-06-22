<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<html lang="en">
<head>
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
	<h2>Users' list:</h2>
	<%
		if (request.getAttribute("message") != null) {
	%>
	<font style="color: #090">${message}</font>
	<br /><br />
	<%
		} else if(request.getAttribute("errorMessage") != null) {
	%>
	<font style="color: #900">${errorMessage}</font>
	<br /><br />
	<%
		}
	%>

	<a href="/addUser">Add a new User</a>
	<br />
	<br />
	<display:table name="users" id="row" class="dispTagTable"
		requestURI="/listUsers">
		<display:column sortable="true" title="Username">
			<a href="users/${row.username}">${row.username}</a>
		</display:column>
		<display:column sortable="true" property="firstName"
			title="First Name" />
		<display:column sortable="true" property="lastName" title="Last Name" />
		<display:column sortable="true" property="phoneNumber"
			title="Phone Number" />
		<display:column sortable="true" title="Email">
			<a target="_blank" href="mailto:${row.email}">${row.email}</a>
		</display:column>
		<display:column title="Delete">
			<a href="/delete/${row.username}"><img src="/img/del.png"
				alt="Delete this record" class="delImg" /></a>
		</display:column>
	</display:table>
	<br />
	<br />
</body>

</html>
