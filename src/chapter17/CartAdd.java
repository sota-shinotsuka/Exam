package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Page;

@WebServlet(urlPatterns={"/chapter17/cart-add"})
public class CartAdd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cart-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);

		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));

//		セッションを取得
//		リクエストに格納されたセッションIDをもとにサーバー上のデータを取得する
		HttpSession session = req.getSession();

//		セッションからカートを取得
//		セッションのデータはObject型なので、キャストをする
		List<Product> cart = (List<Product>)session.getAttribute("cart");
//		初回アクセス時にはcartは空（NULL）なので
		if(cart==null) {
//			空のリストで初期化する
			cart = new ArrayList<Product>();
		}

//		送信された内容でProductインスタンスを生成
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);

//		カートに商品を格納
		cart.add(p);

//		「cart」という名前でカートをセッションに格納
		session.setAttribute("cart", cart);

		out.println("カートに商品を追加しました。");

		out.println("<a href='cart-get'>カートを見る</a>");

		Page.footer(out);
	}



}
