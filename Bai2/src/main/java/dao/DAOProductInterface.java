package dao;

import java.util.List;

import entities.Product;

public interface DAOProductInterface {
	public List<Product> getAllProducts();
	public boolean addProduct(Product p);
	public Product getProductById(int id);
}
