<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1 class="thin center-align">add user chan</h1>
		<form action="UserController" method="GET" id="myform">
			<input type="text" placeholder="Firstname" name="firstname"/>
			<input type="text" placeholder="Lastname" name="lastname"/>
			<input type="email" placeholder="Email" name="email" />
			<button type="submit" class="btn" name="action" value="ADD">Submiit</button>
		</form>
	</div>
</body>
</html>