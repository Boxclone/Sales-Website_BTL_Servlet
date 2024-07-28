package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Account;
import entity.CartItem;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/updateCart")
public class UpdateCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("acc");
		int totalItems = 0;

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart_" + user.getId());
        if (cart == null) {
            cart = new ArrayList<>();
        }

        int productId = Integer.parseInt(request.getParameter("productId"));
        String action = request.getParameter("action");

        for (Iterator<CartItem> iterator = cart.iterator(); iterator.hasNext();) {
            CartItem item = iterator.next();
            if (item.getProduct().getId() == productId) {
                switch (action) {
                    case "increase":
                        item.setQuantity(item.getQuantity() + 1);
                        break;
                    case "decrease":
                        item.setQuantity(item.getQuantity() - 1);
                        if (item.getQuantity() <= 0) {
                            iterator.remove();
                        }
                        break;
                    case "remove":
                        iterator.remove();
                        break;
                }
                break;
            }
        }
        
        for (CartItem item : cart) {
            totalItems += item.getQuantity();
        }
        
        request.setAttribute("totalItems", totalItems);
        request.setAttribute("cart", cart);
        session.setAttribute("cart_" + user.getId(), cart);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
	}

}
