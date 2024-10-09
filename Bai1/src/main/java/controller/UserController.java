package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import daoImpl.UserDAOImpl;
import entities.Error;
import entities.User;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil util;
	private UserDAOImpl userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	util = new EntityManagerFactoryUtil();
    	userDAO = new UserDAOImpl(util.getEntityManager());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String reEmail = request.getParameter("reEmail");
        String password = request.getParameter("password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String gender = request.getParameter("gender");
        
        boolean error = false;
        
        if (firstName == null || firstName.isEmpty()) {
            request.setAttribute("error", new Error("firstName", "First name is empty"));
            error = true;
        } else if (lastName == null || lastName.isEmpty()) { 
            request.setAttribute("error", new Error("lastName", "Last name is empty"));
            error = true;
        } else if (email == null || email.isEmpty()) {
            request.setAttribute("error", new Error("email", "Email is empty"));
            error = true;
        } else if (!email.equals(reEmail)) {
            request.setAttribute("error", new Error("reEmail", "Email and Re-enter are not equal"));
            error = true;
        } else if (password == null || password.isEmpty()) {
            request.setAttribute("error", new Error("password", "Password is empty"));
            error = true;
        } else if (day == null || day.isEmpty() || month == null || month.isEmpty() || year == null || year.isEmpty()) {
            request.setAttribute("error", new Error("date", "Date not selected"));
            error = true;
        } else if (gender == null || gender.isEmpty()) {
            request.setAttribute("error", new Error("gender", "Gender not selected"));
            error = true;
        } 

        
       
        if (error == false) {
        	String birthdayString = day + "/" + month + "/" + year;
    		Date birthDateSql = null;
    		
    		try {
    			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    			birthDateSql = format.parse(birthdayString);
    		} catch (ParseException e) {
    			e.printStackTrace();
    		}
        	User user = new User(firstName, lastName, email, password, birthDateSql, gender);
        	userDAO.addUser(user);
        	request.setAttribute("users", userDAO.getAllUsers());
        	session.setAttribute("firstName", "");
            session.setAttribute("lastName", "");
            session.setAttribute("email", "");
            session.setAttribute("reEmail", "");
            session.setAttribute("password", "");
        	request.getRequestDispatcher("views/user/listUser.jsp").forward(request, response);
        } else {
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("email", email);
            session.setAttribute("reEmail", reEmail);
            session.setAttribute("password", password);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
