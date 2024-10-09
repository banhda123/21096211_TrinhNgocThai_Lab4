package dao;

import java.util.List;

import entities.User;

public interface UserDAOInterface {
	public User addUser(User user);
	public List<User> getAllUsers();
}
