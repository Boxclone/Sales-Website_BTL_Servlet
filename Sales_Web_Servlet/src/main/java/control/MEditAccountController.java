package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class MEditAccountController
 */
@WebServlet("/editaccount")
public class MEditAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("aid");
        DAO dao = new DAO();
        Account a = dao.getAccountByID(id);

        request.setAttribute("detail", a);
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String role = request.getParameter("role");
		
		int isSell = 0;
		
		switch (role) {
        	case "user":
	            isSell = 0;
	            break;
	        case "seller":
	            isSell = 1;
	            break;
	    }
		
		DAO dao = new DAO();
		dao.updateAccount(id, isSell);
		response.sendRedirect("manageraccount");
	}

}
