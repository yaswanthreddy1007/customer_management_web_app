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
	
	RequestDispatcher rd;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("femaillogin");
		String password = request.getParameter("fpasswordlogin");
		
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
			response.sendRedirect("http://localhost:8080/customer_management_system/welcome_admin.jsp");
		}
		
		else if(logincheck.equals("true"))
		{
			HttpSession session = request.getSession();
			session.setAttribute("keyloginname", loginname);
			session.setAttribute("keyloginemail", loginemail);
			response.sendRedirect("http://localhost:8080/customer_management_system/welcome.jsp");
		}
		else {
			rd=request.getRequestDispatcher("css.jsp");  
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("navbar.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("loginerror.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("login.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("about.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("register.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("js.jsp");
		    rd.include(request, response);
		}
		helper.closeConnection();
	}

}
