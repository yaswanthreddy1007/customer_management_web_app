package singh.navjot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import singh.navjot.db.JDBCHelper;

import singh.navjot.model.User;

@WebServlet({ "/loginServlet", "/login" })
public class loginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("femail");
		String password = request.getParameter("fpassword");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		HashMap<String,String> hm=new HashMap<String,String>(); 
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		
		hm = helper.loginUser(user);
		
		String loginname = hm.get("keyname");
		String loginemail = hm.get("keyemail");
		String logincheck = hm.get("keylogincheck");
		
		if(logincheck.equals("true") && loginemail.contains("navjotsingh9633@gmail.com"))
		{
			out.print("Welcome "+loginname);
			
			HttpSession session = request.getSession();
			session.setAttribute("keyloginname", loginname);
			RequestDispatcher rd = request.getRequestDispatcher("welcome_admin.jsp");
			rd.forward(request, response);
//			response.sendRedirect("http://localhost:8080/Customer_management_system/welcome_admin.jsp");
		}
		
		else if(logincheck.equals("true"))
		{
			out.print("Login Success  <br/>");
			out.print("Welcome "+loginname);
		}
		else {
			out.println("<b>Login is Failure..</b>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");  
		    rd.include(request, response);
		}
		helper.closeConnection();
	}

}
