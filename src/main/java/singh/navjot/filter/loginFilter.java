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

	public void destroy() {
		System.out.println("destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("femail").trim();
		String password = request.getParameter("fpassword").trim();
		
		if(email.isEmpty() || password.isEmpty())
		{
			out.println("<div style='color:red;'>Please fill all the details</div>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");  
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
