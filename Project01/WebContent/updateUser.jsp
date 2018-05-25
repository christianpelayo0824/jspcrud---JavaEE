<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/materialize.min.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1 class="thin center-align">update user</h1>
		<form action="UserController" method="GET" id="myform">
			<input type="hidden" name="userId" value="${UPDATE_USER.getUserId()}" />
			<input type="text" placeholder="Firstname" name="firstname" value="${UPDATE_USER.getFirstname()}" /> 
			<input type="text" placeholder="Lastname" name="lastname" value="${UPDATE_USER.getLastname()}"/> 
			<input type="email" placeholder="Email" name="email" value="${UPDATE_USER.getEmail() }"/>
			<button type="submit" class="btn" name="action" value="UPDATE">Submiit</button>
		</form>
	</div>
</body>
</html>