package singh.navjot.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singh.navjot.db.JDBCHelper;

import singh.navjot.model.User;

@WebServlet({ "/registerServlet", "/register" })
public class registerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("fname");
		String email = request.getParameter("femail");
		String password = request.getParameter("fpassword");
		
		User user = new User(name, email, password);
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		int i = helper.registerUser(user);
		
		if(i>0)
		{
			out.print(name+" Registered Successfully");
		}else {
			out.print(name+" didn't get registered");
		}
		
		helper.closeConnection();
	}

}
