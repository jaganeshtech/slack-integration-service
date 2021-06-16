package com.eloqua.rs.eas.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;


public class AuthorizationCodeServlet extends HttpServlet {


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// generate random state parameter and persist in session
		final String secretState = "secret" + new Random().nextInt(999_999);
		req.getSession().setAttribute("SECRET_STATE", secretState);


		// redirect to zoom for authorization
		resp.sendRedirect("");

	}

}
