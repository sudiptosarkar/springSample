package org.k0r0pt.helpers;

import java.util.ArrayList;
import java.util.List;

import org.k0r0pt.beans.UserBean;
import org.k0r0pt.dao.UserManagementDao;
import org.k0r0pt.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserManagementHelper {
	
	@Autowired
	UserManagementDao dao;

	public UserBean getUser(String username) {
		if(dao.count() == 0) {
			return null;
		}
		User user = dao.findByUsername(username);
		return new UserBean(user);
	}
	
	public List<UserBean> getAllUsers() {
		if(dao.count() == 0) {
			return null;
		}
		List<UserBean> users = new ArrayList<>();
		for(User user : dao.findAllByOrderByUsernameAsc()) {
			users.add(new UserBean(user));
		}
		return users;
	}

	public boolean addUser(UserBean user) {
		if(dao.existsByUsername(user.getUsername())) {
			return false;
		}
		dao.save(user.getEntity());
		return true;
	}

	public boolean deleteUser(String username) {
		boolean retVal = false;
		if(dao.existsByUsername(username)) {
			dao.delete(dao.findByUsername(username));
			retVal = true;
		}
		
		return retVal;
	}
	
}
