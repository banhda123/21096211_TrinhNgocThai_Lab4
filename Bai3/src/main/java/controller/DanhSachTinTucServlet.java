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
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class DanhSachTinTucServlet
 */
public class DanhSachTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private EntityManager en;
	private DAODanhMucImpl daoDanhMuc;
	private DAOTinTucImpl daoTinTuc;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachTinTucServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	util = new EntityManagerFactoryUtil();
    	en = util.getEntityManager();
    	daoDanhMuc = new DAODanhMucImpl(en);
    	daoTinTuc = new DAOTinTucImpl(en);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Object[]> dsTinTucByDanhMuc = daoTinTuc.getTinTucByDanhMuc();
    	request.setAttribute("dsDanhMuc", daoDanhMuc.getAllDanhMuc());
    	
    	String id = request.getParameter("danhMucId");
    	if (id == null || id.isEmpty()) 
    		request.setAttribute("dsTinTuc", daoTinTuc.getAllTinTuc());
    	else {
    		request.setAttribute("dsTinTuc", daoTinTuc.getTinTucByDanhMuc(Integer.parseInt(id)));
    		request.setAttribute("danhMucSelected", daoDanhMuc.getDanhMucById(Integer.parseInt(id)).getTenDanhMuc());
    	}
    	
    	request.getRequestDispatcher("/views/DanhSachTinTuc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
