package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.DAOProductInterface;
import entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAOProductImpl implements DAOProductInterface{
	private EntityManager manager;

	public DAOProductImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> ds = new ArrayList<Product>();
		try {
			ds = manager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	@Override
	public boolean addProduct(Product p) {
		EntityTransaction trans = null;
		try {
			trans = manager.getTransaction();
			trans.begin();
			manager.persist(p);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product getProductById(int id) {
		Product p = null;
		try {
			p = manager.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	
	
}
