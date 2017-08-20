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


@WebFilter({ "/loginFilter", "/login" })
public class loginFilter implements Filter {
	
	RequestDispatcher rd;

	public void destroy() {
		System.out.println("destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("femaillogin").trim();
		String password = request.getParameter("fpasswordlogin").trim();
		
		if(email.isEmpty() || password.isEmpty())
		{
			rd=request.getRequestDispatcher("css.jsp");  
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("navbar.jsp");
		    rd.include(request, response);
		    
		    rd=request.getRequestDispatcher("validation.jsp");
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
		else {
				chain.doFilter(request, response);
		}
			
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init()");
	}

}
