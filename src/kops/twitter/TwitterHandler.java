package kops.twitter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class TwitterHandler extends AbstractHandler {
	
	@Override
	public void handle(String target,
			Request baseRequest,
			HttpServletRequest request, 
			HttpServletResponse response) 
			throws IOException, ServletException{

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);	//status code - 200
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>Hello World!!</h1><h2>Hello World!!</h2>");
		
	}


}
