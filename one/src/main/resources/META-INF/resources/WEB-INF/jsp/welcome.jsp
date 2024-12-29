<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %> 

<!--<html>
	<head>
	<title> Login page</title>
	</head>

	<body>
		Welcome to login page !  ${name}
		
	</body>
</html> -->

	<!--<body>
		<div>Welcome to ${name}</div>
		<hr>
		<div>Your Name:${name}</div>
		<div><a href="list-todos">Manage</a>your todos</div>
		<div>Your password:${password}</div>
	</body> -->

		<div class="container">
			<h1>Welcome ${name}</h1>
			<hr>
			<!--<div>Your Name:${name}</div>-->
			<a href="list-todos">Manage</a> your todos
			<!--<div>Your password:${password}</div>-->
		</div>

<%@ include file="common/footer.jspf" %>
