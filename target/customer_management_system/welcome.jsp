<%@page import="singh.navjot.db.JDBCHelper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<jsp:include page="css.jsp"></jsp:include>
</head>
<body>
	<% 	String name = (String)session.getAttribute("keyloginname");
		String email = (String)session.getAttribute("keyloginemail");
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		int points = helper.getpoints(email);
	%>
	
	<div class="container">
		<div class="row">
			<h1>Welcome <%=name %></h1>
		</div>
		<p class="lead">Your points <%=points %></p>
		
		<form action="logout" method="post">
			<input type="submit" value="Logout" class="btn btn-primary"/>
		</form>
	</div>
	
		
	
	
</body>
</html>