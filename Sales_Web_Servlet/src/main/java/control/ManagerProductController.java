package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class ManagerProductController
 */
@WebServlet("/managerproduct")
public class ManagerProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		List<Product> listP = dao.getAllProduct();
		List<Category> listC = dao.getAllCategory();

        request.setAttribute("listCC", listC);
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);

	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
