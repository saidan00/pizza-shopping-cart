package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BasicFilter
 */
public class BasicFilter implements Filter {
	
	private static final String CLASS = BasicFilter.class.getSimpleName();

    /**
     * Default constructor. 
     */
    public BasicFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    // called once when the Filter off loaded by container
	public void destroy() {
		System.out.println(CLASS + "::destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	// called every time when filter url-mapping matches
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println(CLASS + "::doFilter() - Inside Filter.");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println(CLASS + "::doFilter() - Invoking Resource=>" + req.getRequestURL());
		System.out.println(CLASS + "::doFilter() - Response Code=>" + res.getStatus());
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	// called only once when the Filter first time invoked
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println(CLASS + "::init()");
	}

}
