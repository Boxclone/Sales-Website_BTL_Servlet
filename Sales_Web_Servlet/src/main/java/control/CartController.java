package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;
import entity.CartItem;
import entity.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("acc");
        List<CartItem> cart = null;
        int totalItems = 0;
        
        if (user != null) {
            cart = (List<CartItem>) session.getAttribute("cart_" + user.getId());
            if (cart == null) {
                cart = new ArrayList<>();
            }
            for (CartItem item : cart) {
                totalItems += item.getQuantity();
            }
        } else {
		     response.sendRedirect("Login.jsp");
		     return;
        }

        request.setAttribute("cart", cart);
        request.setAttribute("totalItems", totalItems);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("acc");
		int totalItems = 0;
		
		 if (user == null) {
            response.sendRedirect("Login.jsp");
            return;
        }
		
		 List<CartItem> cart = (List<CartItem>) session.getAttribute("cart_" + user.getId());

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String productID = request.getParameter("pid");
        
        DAO dao = new DAO();
        Product p = dao.getProductByID(productID);
        
        boolean found = false;

        for (CartItem item : cart) {
            if (item.getProduct().getId() == p.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            cart.add(new CartItem(p, 1));
        }
        
        for (CartItem item : cart) {
            totalItems += item.getQuantity();
        }

        session.setAttribute("cart_" + user.getId(), cart);
        request.setAttribute("cart", cart);
        request.setAttribute("totalItems", totalItems);

        // Lưu ID người dùng vào cookie nếu đã đăng nhập
        if (user != null) {
            Cookie userCookie = new Cookie("userId", String.valueOf(user.getId()));
            userCookie.setMaxAge(12 * 60 * 60); // 12 giờ
            response.addCookie(userCookie);
        }

        request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

}
