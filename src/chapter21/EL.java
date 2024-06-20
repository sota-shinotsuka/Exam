package chapter21;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;

@WebServlet(urlPatterns={"/chapter21/el"})
public class EL extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		p.setId(1);
		p.setName("まぐろ");
		p.setPrice(100);

		req.setAttribute("product", p);

		HttpSession session = req.getSession();
		session.setAttribute("data", "セッションデータ");

		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}

}
