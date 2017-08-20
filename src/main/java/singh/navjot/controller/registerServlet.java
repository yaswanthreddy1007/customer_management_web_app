package singh.navjot.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import singh.navjot.db.JDBCHelper;

import singh.navjot.model.User;

@WebServlet({ "/registerServlet", "/register" })
public class registerServlet extends HttpServlet {
	
	RequestDispatcher rd;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("fnameregister");
		String email = request.getParameter("femailregister");
		String password = request.getParameter("fpasswordregister");
		
		User user = new User(name, email, password);
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		int i = helper.registerUser(user);
		
		if(i>0)
		{

			rd=request.getRequestDispatcher("css.jsp");  
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("navbar.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("registered.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("home.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("about.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("login.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("register.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("js.jsp");
		    rd.include(request, response);
			
		}else {
			rd=request.getRequestDispatcher("css.jsp");  
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("navbar.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("notregistered.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("home.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("about.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("login.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("register.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("js.jsp");
		    rd.include(request, response);
		}
		
		helper.closeConnection();
	}

}
