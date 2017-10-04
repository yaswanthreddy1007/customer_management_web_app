<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"
	    import="singh.navjot.db.JDBCHelper"
	    import="java.util.ArrayList"
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
<jsp:include page="css.jsp"></jsp:include>
</head>
<body>
	<% 	String name = (String)session.getAttribute("keyloginname");%>

	<%
	ArrayList<String> userslist=new ArrayList<String>();
	JDBCHelper helper = new JDBCHelper();
	helper.openConnection();
	userslist = helper.retrieveUsers();
	helper.closeConnection();
	%>

<div class="container">	
	<h1>Welcome <%=name %></h1>
	<br/><br/>
	<form id="bill_form" action="bill.jsp">
		<input id="frowcount" name="frowcount" type="number" hidden />
		<h3>Users:</h3>
			<select id="fuser" name="fuser">
				<option value="select users">select user</option>
				<%
				for (int i = 0; i < userslist.size(); i++) 
				{
				%>
				<option value="<%out.print(userslist.get(i)); %>"><%out.print(userslist.get(i)); %></option>
			  <%} %>
			</select>
			<br/><br/>
			<table id="ftable">
				<tr> <th>ITEM</th><th>PRICE</th><th>QUANTITY</th> </tr>
				<tr> 
					<td><input name="fitem1" id="fitem1" type="text" min=1 placeholder="Enter item" required/></td> 
					<td><input name="fprice1" id="fprice1" type="number" min=1 placeholder="Enter price" required/></td> 
					<td><input name="fquantity1" id="fquantity1" type="number" min=1 placeholder="Enter quantity" required/></td> 
				</tr>
				<tr id="emptyrow"></tr>
			</table>
			<br/>
			<input class="btn btn-primary" type="button" onclick="addrow()" value="ADD" />
			<input class="btn btn-success" type="submit" value="Generate Bill" />
	</form>
	<br/><br/><br/>
	<form action="logout" method="post">
			<input type="submit" value="Logout" class="btn btn-primary"/>
		</form>
</div>

	<script type="text/javascript" src="js/admin.js"></script>
	<jsp:include page="js.jsp"></jsp:include>
</body>
</html>