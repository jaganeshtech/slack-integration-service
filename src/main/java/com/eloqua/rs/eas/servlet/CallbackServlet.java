package com.eloqua.rs.eas.servlet;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;


public class CallbackServlet extends HttpServlet {


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		try {

			final String secretState = (String) req.getSession().getAttribute("SECRET_STATE");
			final String code = req.getParameter("code");


		} catch (Exception exe) {
			Logger.getLogger("callback sevlet").info("Sevlet Error:" + exe.toString());
		}
		// close popup window
		resp.setContentType("text/html");
		out.print("	<html>"
				+ "		<head>"
				+ "		</head>"
				+ "		<body>"
				+ "			<script>window.close()</script>"
				+ "		</body"
				+ "	</html");
	}
	
	
	
	
	
	

}//
