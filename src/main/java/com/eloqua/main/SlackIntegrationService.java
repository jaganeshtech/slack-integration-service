package com.eloqua.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;

import com.eloqua.rs.eas.servlet.AuthorizationCodeServlet;
import com.eloqua.rs.eas.servlet.CallbackServlet;
import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.request.chat.ChatDeleteRequest;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.api.ApiTestResponse;
import com.slack.api.methods.response.chat.ChatDeleteResponse;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;

@SpringBootApplication
@ComponentScan({ "com.eloqua" })
@ServletComponentScan
public class SlackIntegrationService extends SpringBootServletInitializer
		implements WebApplicationInitializer, CommandLineRunner {
	

	public static void main(String[] args) throws Exception {

		SpringApplication.run(SlackIntegrationService.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SlackIntegrationService.class);
	}

	

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new AuthorizationCodeServlet(), "/oauth/authorize");
		return bean;
	}

	@Bean
	public ServletRegistrationBean callbackServlet() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new CallbackServlet(), "/oauth/callback");
		return bean;
	}

	@Override
	public void run(String... args) throws Exception {
		 Slack slack = Slack.getInstance();
		    ApiTestResponse response = slack.methods().apiTest(r -> r.foo("bar"));
		    System.out.println(response);
		
		    
		 // Load an env variable
		 // If the token is a bot token, it starts with `xoxb-` while if it's a user token, it starts with `xoxp-`
		 String token = "xoxb-2160202127670-2167203315155-F2dnLrkAUlr0BsffwEBua11z";

		 // Initialize an API Methods client with the given token
		 MethodsClient methods = slack.methods(token);

		 
		 // Build a request object
		 
		 ChatPostMessageRequest request = ChatPostMessageRequest.builder()
				   .channel("C024TSM2805") // Use a channel ID `C1234567` is preferrable
				   .text(":wave: Hi from a ganesh added new message from java code!")
				   .build();
		 
		 
		 ChatDeleteRequest delete = ChatDeleteRequest.builder().channel("C024TSM2805").ts("1623669002.000400").build();
				 
				 
				 
		 // Get a response as a Java object
		 ChatPostMessageResponse responseObj = methods.chatPostMessage(request);
		  System.out.println(responseObj.toString());  		
		ChatDeleteResponse deleteResp=  methods.chatDelete(delete);
		  System.out.println(deleteResp.toString());  		  
	}
}
