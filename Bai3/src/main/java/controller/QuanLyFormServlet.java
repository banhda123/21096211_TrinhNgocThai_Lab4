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

import daoImpl.DAODanhMucImpl;
import daoImpl.DAOTinTucImpl;
import entities.TinTuc;

/**
 * Servlet implementation class QuanLyFormServlet
 */
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private EntityManager en;
	private DAOTinTucImpl daoTinTuc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	util = new EntityManagerFactoryUtil();
    	en = util.getEntityManager();
    	daoTinTuc = new DAOTinTucImpl(en);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGetShowPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<TinTuc> dsTinTuc = daoTinTuc.getAllTinTuc();
    	request.setAttribute("dsTinTuc", dsTinTuc);
    	request.getRequestDispatcher("/views/QuanLyForm.jsp").forward(request, response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGetRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
    	daoTinTuc.removeTinTuc(Integer.parseInt(id));
    	List<TinTuc> dsTinTuc = daoTinTuc.getAllTinTuc();
    	request.setAttribute("dsTinTuc", dsTinTuc);
    	request.getRequestDispatcher("/views/QuanLyForm.jsp").forward(request, response);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
			case "showPage": 
				doGetShowPage(request, response);
				break;
				
			case "remove": 
				doGetRemove(request, response);
				break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
