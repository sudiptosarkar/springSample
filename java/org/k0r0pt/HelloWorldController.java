package org.k0r0pt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author sudiptos
 * 
 * <p>This is just a simple Hello World Spring application.
 * This class has two methods. The main method is to init Spring Bootstrap.
 * The home method just returns a String saying hello (to the) world.</p>
 * 
 * SpringBootServletInitializer has been extended so that this can be 
 * run straight out of a traditional war file.
 * 
 * @see SpringBootServletInitializer
 *
 */
@Controller
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan
public class HelloWorldController extends SpringBootServletInitializer {
	
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	
	/**
	 * This method will handle requests to /login and will send user to a protected URL.
	 * 
	 * @return the JSP to which this URL will log the user into.
	 */
	@RequestMapping("/login**")
	public String login(ModelMap model) {
		model.put("message", this.message);
		return "loggedIn";
	}

	/**
	 * This method initializes Spring Boot on the class HelloWorldController.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldController.class, args);
	}
}
