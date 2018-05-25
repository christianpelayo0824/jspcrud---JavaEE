<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/materialize.min.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="thin center-align">list user</h1>
		<button class="btn waves-effect waves-light" value="Add Student"
			onclick="window.location.href='addUser.jsp'; return false;">ADD
			USER</button>
		<table class="striped highlight centered responsive-table">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${USERLIST}" var="USER">
					<c:url var="deleteLink" value="UserController">
						<c:param name="action" value="DELETE"></c:param>
						<c:param name="userId" value="${USER.getUserId()}"></c:param>
					</c:url>
					<c:url var="updateLink" value="UserController">
						<c:param name="action" value="LOAD"></c:param>
						<c:param name="userId" value="${USER.getUserId()}"></c:param>
					</c:url>
					<tr>
						<td><c:out value="${USER.getFirstname()}"></c:out></td>
						<td><c:out value="${USER.getLastname()}"></c:out></td>
						<td><c:out value="${USER.getEmail()}"></c:out></td>
						<td><a class="btn waves-effect" href="${deleteLink} ">DELETE</a>
							| <a class="btn waves-effect" href="${updateLink}">UPDATE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>