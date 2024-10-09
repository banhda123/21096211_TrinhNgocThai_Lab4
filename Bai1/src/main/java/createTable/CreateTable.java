package createTable;

import jakarta.persistence.EntityManager;
import utils.EntityManagerFactoryUtil;

public class CreateTable {
	public static void main(String[] args) {
		EntityManagerFactoryUtil util = new EntityManagerFactoryUtil();
		EntityManager em = util.getEntityManager();
	}
}
