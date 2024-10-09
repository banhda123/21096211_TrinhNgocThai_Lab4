package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class  EntityManagerFactoryUtil{
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("quanlydanhmuc");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
//	public static void main(String[] args) {
//		EntityManagerFactoryUtil util = new EntityManagerFactoryUtil();
//		
//		try {
//			EntityManager manager = util.getEntityManager();
//			if (manager.isOpen()) {
//				System.out.println("Connection successful");
//			} else 
//				System.out.println("Connection failed");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
}
