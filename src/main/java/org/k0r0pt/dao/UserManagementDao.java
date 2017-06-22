package org.k0r0pt.dao;

import java.util.List;

import org.k0r0pt.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserManagementDao extends CrudRepository<User, Long> {
	public User findByUsername(String username);

	public boolean existsByUsername(String username);

	public List<User> findAllByOrderByUsernameAsc();
}
