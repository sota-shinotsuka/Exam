package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/all2"})
public class All2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);

		try{
//			ProductDAOのallメソッドを使って全商品を取得
			ProductDAO pDao = new ProductDAO();
			List<Product> list = pDao.all();

//			取得した結果を表示
//			リストから1件ずつ取り出すループ
			for (Product p : list) {
				out.println(p.getId());
				out.println(":");
				out.println(p.getName());
				out.println(":");
				out.println(p.getPrice());
				out.println("<br>");
			}

		}catch(Exception e){
			e.printStackTrace(out);
		}

		Page.footer(out);
	}

}
