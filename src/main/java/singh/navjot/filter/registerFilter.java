package singh.navjot.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import singh.navjot.db.JDBCHelper;
import singh.navjot.model.User;

@WebFilter("/register")
public class registerFilter implements Filter {

	RequestDispatcher rd;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		out.print(" <link rel='stylesheet' type='text/css' href='"+  request.getServletContext().getRealPath("/")+"css\\custom.css' />");
//out.print(request.getServletContext().getRealPath("/")+"css/custom.css'>");
		
		String name = request.getParameter("fnameregister").trim();
		String email = request.getParameter("femailregister").trim();
		String password = request.getParameter("fpasswordregister").trim();
		
		if(name.isEmpty() || email.isEmpty() || password.isEmpty())
		{
			rd=request.getRequestDispatcher("css.jsp");  
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("navbar.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("validation.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("register.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("about.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("login.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("js.jsp");
		    rd.include(request, response);
		} 
		else {
			User user = new User();
			user.setEmail(email);
			
			JDBCHelper helper = new JDBCHelper();
			helper.openConnection();
			String existingemail = helper.existinguser(user);
			helper.closeConnection();
			
			if(existingemail.length()>0)
			{
				rd=request.getRequestDispatcher("css.jsp");  
			    rd.include(request, response);
			    
			    rd=request.getRequestDispatcher("navbar.jsp");
			    rd.include(request, response);
			    
			    rd=request.getRequestDispatcher("existuser.jsp");
			    rd.include(request, response);
			    
			    rd=request.getRequestDispatcher("register.jsp");
			    rd.include(request, response);
			    
			    rd=request.getRequestDispatcher("about.jsp");
			    rd.include(request, response);
			    
			    rd=request.getRequestDispatcher("login.jsp");
			    rd.include(request, response);
			    
			    rd=request.getRequestDispatcher("js.jsp");
			    rd.include(request, response);
				
			}
			else {
				chain.doFilter(request, response);
			}
		}
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
