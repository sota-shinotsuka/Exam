package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/insert2"})
public class Insert2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("insert2.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);
		try {
			String name=req.getParameter("name");
			int price=Integer.parseInt(req.getParameter("price"));

			Product p = new Product();
			p.setName(name);
			p.setPrice(price);

			ProductDAO pdao = new ProductDAO();
			int line = pdao.insert(p);

			if (line>0){
				out.println("追加に成功しました。");
			}

		}catch (Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
