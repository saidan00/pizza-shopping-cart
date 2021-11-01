package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicServlet
 */
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ServletConfig servletConfig;
	
	private String servletInitParameterValue;
	
	private String contextParameterValue;
	
	// initialize once through of teh life cycle of servlet
	private String loginTime;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.print("BasicServlet:********** init() **********");
		//get ServletConfig
		this.servletConfig = config;
		
		// use ServletConfig to get Servlet Init Parameters
		servletInitParameterValue = servletConfig.getInitParameter("ServletInitParameter");
		System.out.println("ServletInitParameterValue:" + servletInitParameterValue);
		
		// use ServletConfig to get Context Init Parameters
		contextParameterValue = servletConfig.getServletContext().getInitParameter("ContextParameter");
		System.out.println("ContextParameterValue:" + contextParameterValue);
		
		loginTime = this.getDateTime();
	}

	/**
	 * @see Servlet#destroy()
	 */
	// call when the servlet will be destroyed by the container
	public void destroy() {
		System.out.println("I am destroyed");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\nBasicServlet:********** doGet() **********");
		
		// get request parameter
		String requestParamValue = request.getParameter("param");
		
		// Set response context type
		response.setContentType("text/html");
		
		// create web page and write message to that
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<br>");
		out.println("<h3>" + this.getServletInfo() + " invoked at " + this.getDateTime() + ". I got init-param="
				+ servletInitParameterValue + " and context-param=" + contextParameterValue + "<br>"
				+ "You logged in at:" + loginTime + " passing request parameter param as " + requestParamValue
				+ "</h3>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/** Other methods */
	// return any servlet information like sevrlet name
	public String getServletInfo() {
		return this.servletConfig.getServletName();
	}
	
	// return ServletConfig created when the servlet initialized
	public ServletConfig getServletConfig() {
		return servletConfig;
	}
	

	// return formatted date & time
	private String getDateTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateS = format.format(date);
		return dateS;
	}
}
