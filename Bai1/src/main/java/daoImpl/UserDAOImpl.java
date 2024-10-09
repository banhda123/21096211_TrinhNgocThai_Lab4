package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.UserDAOInterface;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UserDAOImpl implements UserDAOInterface{
	private EntityManager entityManager;
	
	public UserDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public User addUser(User user) {
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			entityManager.persist(user);
			trans.commit();
			return user;
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
