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
 * Servlet implementation class MEditProductController
 */
@WebServlet("/editproduct")
public class MEditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("pid");
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);
        List<Category> listC = dao.getAllCategory();

        request.setAttribute("detail", p);
        request.setAttribute("listCC", listC);
        request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        DAO dao = new DAO();
        dao.updateProduct(name, image, price, title, description, category, id);
        response.sendRedirect("managerproduct");
	}

}
