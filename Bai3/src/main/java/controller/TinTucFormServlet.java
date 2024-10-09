package controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import daoImpl.DAODanhMucImpl;
import daoImpl.DAOTinTucImpl;
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class TinTucFormServlet
 */
public class TinTucFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private EntityManager en;
	private DAODanhMucImpl daoDanhMuc;
	private DAOTinTucImpl daoTinTuc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinTucFormServlet() {
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
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPostThemTinTuc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String tenDanhMuc = request.getParameter("tenDM");
    	int id = daoDanhMuc.getIdByName(tenDanhMuc);
    	String lienKet = request.getParameter("lienKet");
    	String noiDung = request.getParameter("noiDung");
    	String tieuDe = request.getParameter("tieuDe");
    	String error = "";
    	if (tieuDe.length() == 0) {
    		error = "Tiêu đề chưa nhập";
    	}
    	
    	if (noiDung.length() == 0) {
    		error = "Nội dung chưa nhập";
    	} 
    	
    	if (noiDung.length() > 255) {
    		error = "Nội dung không quá 255 kí tự";
    	}
    	String regex = "^http://.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lienKet);
        if (!matcher.matches()) {
        	error = "Liên kết bắt đầu bởi \"http://\"";
        }
    	
    	
    	if (error.length() == 0) {
    		DanhMuc danhMuc = daoDanhMuc.getDanhMucById(id);
        	TinTuc tinTuc = new TinTuc(tieuDe, noiDung, lienKet, danhMuc);
        	daoTinTuc.themTinTuc(tinTuc);
        	request.setAttribute("dsDanhMuc", daoDanhMuc.getAllDanhMuc());
        	request.setAttribute("dsTinTuc", daoTinTuc.getAllTinTuc());
        	request.getRequestDispatcher("/views/DanhSachTinTuc.jsp").forward(request, response);
    	} else {
    		request.setAttribute("error", error);
    		List<DanhMuc> dsDanhMuc = daoDanhMuc.getAllDanhMuc();
        	request.setAttribute("dsDanhMuc", dsDanhMuc);
        	request.getRequestDispatcher("/views/TinTucForm.jsp").forward(request, response);
    	}
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGetShowPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<DanhMuc> dsDanhMuc = daoDanhMuc.getAllDanhMuc();
    	request.setAttribute("dsDanhMuc", dsDanhMuc);
    	request.getRequestDispatcher("/views/TinTucForm.jsp").forward(request, response);
    	
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		
//		switch (action) {
//			case "showPage": 
//				doGetShowPage(request, response);
//				break;
//				
//			case "add": 
//				doPostThemTinTuc(request, response);
//				break;
//		}
		doGetShowPage(request, response);
		
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPostThemTinTuc(request, response);
	}

}
