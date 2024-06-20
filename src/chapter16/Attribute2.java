package chapter16;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

@WebServlet(urlPatterns={"/chapter16/attribute2"})
public class Attribute2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter out = resp.getWriter();
		try{
//			データベースから商品テーブルのすべてを参照
			ProductDAO dao = new ProductDAO();
			List<Product> list = dao.search("");

//			リクエスト属性に「list」という名前でlistを保持
			req.setAttribute("list", list);

			req.getRequestDispatcher("attribute2.jsp").forward(req, resp);
		}catch(Exception e){
//			e.printStackTrace(out);
			e.printStackTrace(System.out);
		}
	}

}
