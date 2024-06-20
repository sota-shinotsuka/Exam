package chapter17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Page;

@WebServlet(urlPatterns={"/chapter17/cart-remove"})
public class CartRemove extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);

		HttpSession session = req.getSession();
//		removeAttributeメソッド...セッション指定した名前のデータ（一部）を削除する
		session.removeAttribute("cart");
//		invalidateメソッド...セッションをすべて削除する
//		session.invalidate();

		out.println("カートを削除しました。<br>");
		out.println("<a href='cart-add'>カートに追加</a><br>");
		out.println("<a href='cart-get'>カートを見る</a>");

		Page.footer(out);
	}

}
