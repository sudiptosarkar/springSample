package org.k0r0pt.controllers;

import org.k0r0pt.beans.UserBean;
import org.k0r0pt.helpers.UserManagementHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sudiptos
 * 
 *         <p>
 *         This is just a simple Hello World Spring application. This class has
 *         two methods. The main method is to init Spring Bootstrap. The home
 *         method just returns a String saying hello (to the) world.
 *         </p>
 * 
 * @see SpringBootServletInitializer
 *
 */
@Controller
public class UserManagementController {

	@Autowired
	UserManagementHelper helper;

	@Value("${welcome.message:testing 123}")
	private String message = "Hello World";

	@RequestMapping("/")
	// @ResponseBody
	String home() {
		return "index";
	}

	/**
	 * This method will handle requests to /login and will send user to a
	 * protected URL.
	 * 
	 * @return the JSP to which this URL will log the user into.
	 */
	@RequestMapping("/listUsers")
	public String listUsers(ModelMap model) {
		model.put("users", helper.getAllUsers());
		return "listUsers";
	}

	@RequestMapping("/users/{username}")
	public String searchUsername(@PathVariable String username, ModelMap model) {
		UserBean user = helper.getUser(username);
		model.put("user", user);
		return "userDetails";
	}
	
	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username, ModelMap model) {
		if (helper.deleteUser(username)) {
			model.put("message", "User ".concat(username).concat(" deleted successfully."));
		} else {
			model.put("errorMessage", "Requested user deletion failed. ".concat(username).concat(" does not exist."));
		}
		return listUsers(model);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String showAddUser(ModelMap model) {
		model.put("user", new UserBean());
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserBean user, ModelMap model) {
		if (helper.addUser(user)) {
			model.put("user", user);
			model.put("message", "New user ".concat(user.getUsername()).concat(" added successfully"));
			return this.listUsers(model);
		} else {
			model.put("errorMessage", "Failed to add new user. User ".concat(user.getUsername()).concat(" already exists."));
			return this.listUsers(model);
		}
	}
}
