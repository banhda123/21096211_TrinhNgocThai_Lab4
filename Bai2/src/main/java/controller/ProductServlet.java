package controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;

import daoImpl.DAOProductImpl;
import entities.Product;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private EntityManager manager;
	private DAOProductImpl daoProduct;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * initial
     */
    
    @Override
    public void init() throws ServletException {
    	util = new EntityManagerFactoryUtil();
    	manager = util.getEntityManager();
    	daoProduct = new DAOProductImpl(manager);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		daoProduct.addProduct(new Product("Iphone 13", 10000000, "ip13.jpg"));
//		daoProduct.addProduct(new Product("Iphone 14", 10000000, "ip14.jpg"));
//		daoProduct.addProduct(new Product("Iphone 14 Promax", 10000000, "ip14promax.jpg"));
//		daoProduct.addProduct(new Product("Iphone 15 Promax", 10000000, "ip15promax.jpg"));
//		daoProduct.addProduct(new Product("Iphone 16", 10000000, "ip16.jpg"));
//		daoProduct.addProduct(new Product("Iphone 16 Promax", 10000000, "ip16promax.jpg"));
		
		List<Product> ds = daoProduct.getAllProducts();
		request.setAttribute("products", ds);
		request.getRequestDispatcher("/views/product/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
