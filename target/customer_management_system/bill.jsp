
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="singh.navjot.pdf.PDFHelper"%>
<%@page import="singh.navjot.db.JDBCHelper"%>
<%@page import="org.omg.CORBA.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="java.util.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill</title>
</head>
<body>
	<%!
		ArrayList<String> alitem=new ArrayList<String>();
		ArrayList<String> alprice=new ArrayList<String>();
		ArrayList<String> alquantity=new ArrayList<String>();
		int rowcount;
		String useremail;
	%>
		
	<%
		rowcount = Integer.valueOf(request.getParameter("frowcount"));
	
		useremail = request.getParameter("fuser");	
	
		for(int i=1; i<=rowcount; i++){
			alitem.add( request.getParameter("fitem"+i) ); 
		}
		
		for(int i=1; i<=rowcount; i++){
			alprice.add( request.getParameter("fprice"+i) ); 
		}
		
		for(int i=1; i<=rowcount; i++){
			alquantity.add( request.getParameter("fquantity"+i) ); 
		}
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		helper.incrementpoints(useremail);
		helper.closeConnection();
	%>
	
	<%
	int a=Integer.valueOf(alprice.get(0)) * Integer.valueOf(alquantity.get(0));
	
		PDFHelper pdfh = new PDFHelper();
		String dest = pdfh.initialisepdf(useremail);
	
		pdfh.createtable(rowcount, 6, alitem, alprice, alquantity);
		
		pdfh.closepdf();
	%>
	
	<%
//		response.setContentType("application/pdf");
		
		
//	response.setHeader("Content-Disposition", "inline; filename=\"" + dest + "\"");

//		response.setHeader("Content-Disposition", "inline; filename=" + dest + ";");
//		FileOutputStream fileOut = new FileOutputStream(dest);


	
//		fileOut.close();
//		out.close();

	/*	response.setContentType("application/pdf");
			  String filepath = "E:/lucky-I.T/JAVA Advanced/Eclipse_JEE_Workspace/customer_management_system/src/main/java/pdfoutputs/helloworld.pdf";
			  response.setHeader("Content-Disposition", "inline; filename=’helloworld.pdf'");
			  FileOutputStream fileout = new FileOutputStream(filepath);
			  fileout.close();
			  out.close();*/

	%>
	
	

    <% 
	  	alitem.clear();
		alprice.clear();
		alquantity.clear();
    %>
  
  
</body>
</html>