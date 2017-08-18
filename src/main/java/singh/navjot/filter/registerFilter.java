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

    public registerFilter() {
        
    }

	
	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		out.print(" <link rel='stylesheet' type='text/css' href='"+  request.getServletContext().getRealPath("/")+"css\\custom.css' />");
//out.print(request.getServletContext().getRealPath("/")+"css/custom.css'>");
		
		String name = request.getParameter("fname").trim();
		String email = request.getParameter("femail").trim();
		String password = request.getParameter("fpassword").trim();
		
		if(name.isEmpty() || email.isEmpty() || password.isEmpty())
		{
			out.println("<div class='red'>Please fill all the details</div>");
			RequestDispatcher rd=request.getRequestDispatcher("register.html");  
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
				out.print(email+" already exist <br/><br/>");
				RequestDispatcher rd=request.getRequestDispatcher("register.html");  
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
