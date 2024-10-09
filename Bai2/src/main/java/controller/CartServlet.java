package controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import daoImpl.DAOProductImpl;
import entities.CartItem;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private EntityManager manager;
	private DAOProductImpl daoProduct; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		switch (action) {
		case "show": 
			doGetShow(request, response);
			break;
		case "buy": 
			doGetBuy(request, response);
			break;
		case "remove": 
			doGetRemove(request, response);
			break;
		case "update": 
			doGetUpdate(request, response);
			break;
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGetUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		int index = isExistCart(cart, Integer.parseInt(request.getParameter("id")));
		if (index == -1) {
			session.setAttribute("cart", cart);
		} else {
			cart.get(index).setQuantity(Integer.parseInt(request.getParameter("quantity")));
			session.setAttribute("cart", cart);
		}
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doGetRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		int index = isExistCart(cart, Integer.parseInt(request.getParameter("id")));
		if (index == -1) {
			session.setAttribute("cart", cart);
		} else {
			cart.remove(index);
			session.setAttribute("cart", cart);
		}
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doGetBuy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> cart = null;
		if (session.getAttribute("cart") == null)
			cart = new ArrayList<CartItem>();
		else
			cart = (List<CartItem>) session.getAttribute("cart");
		
		int index = isExistCart(cart, Integer.parseInt(request.getParameter("id")));
		if (index == -1) {
			cart.add(new CartItem(daoProduct.getProductById(Integer.parseInt(request.getParameter("id"))), 1));
		} else {
			cart.get(index).setQuantity(cart.get(index).getQuantity() + 1);
		}
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doGetShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<CartItem> cart = null;
		if (session.getAttribute("cart") == null)
			cart = new ArrayList<CartItem>();
		else
			cart = (List<CartItem>) session.getAttribute("cart");
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private int isExistCart(List<CartItem> ds, int id) {
		for (int i = 0; i < ds.size(); i++) {
			if (id == ds.get(i).getProduct().getId())
				return i;
		}
		return -1;
	}

}
