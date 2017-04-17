package com.komal;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor 
{
	private static final Logger logger = Logger.getAnonymousLogger();
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String ip = fetchIP(request);
		if(IpConfigurator.isIpAllowed(ip))
		{
			String responseString = "<html><body><H2>Welcome to Test project... </h2></body></html>";
			System.out.println(responseString);

			response.getWriter().append(responseString);
		}
		else
		{
			logger.warning("Ignoring request from IP: " + ip);
		}
	}
	
	private String fetchIP(HttpServletRequest request) 
	{
		String ip = request.getRemoteAddr();
		if(null == ip || ip.equals(""))
			ip = request.getHeader("X-FORWARDED-FOR");
		
		return ip;
	}
}
