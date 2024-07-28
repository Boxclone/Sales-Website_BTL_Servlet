package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;
import entity.CartItem;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String cateID = request.getParameter("cid"); //get category ID
        
        DAO dao = new DAO();
        List<Product> listP = dao.getProductByCID(cateID);
        List<Category> listC = dao.getAllCategory();
        Product last = dao.getLast();
        
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc");
        List<CartItem> cart = null;
        int totalItems = 0;
        if (user != null) {
	        cart = (List<CartItem>) session.getAttribute("cart_" + user.getId());
	        if (cart != null) {
		        for (CartItem item : cart) {
		            totalItems += item.getQuantity();
		        }
	        }
        } else {
		     response.sendRedirect("Login.jsp");
		     return;
        }
        request.setAttribute("totalItems", totalItems);
        
        request.setAttribute("listP", listP);
        request.setAttribute("listCC", listC);
        request.setAttribute("p", last);
        request.setAttribute("tag", cateID);
        request.getRequestDispatcher("Home.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
