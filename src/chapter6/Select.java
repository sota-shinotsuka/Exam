package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter6/select"})
public class Select extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();

		req.setCharacterEncoding("UTF-8");

//		送信されなかったデータを取得するとnull
		String count=req.getParameter("count");
		String payment=req.getParameter("payment");
		String review=req.getParameter("review");
		String mail=req.getParameter("mail");

		Page.header(out);
		out.println("<p>個数：" + count + "</p>");
		out.println("<p>支払方法：" + payment + "</p>");
		out.println("<p>レビュー：" + review + "</p>");

//		チェックされなかったときは、そもそもデータは送信されない
		if (mail != null) {
			out.println("<p>メールを送ります</p>");
		} else {
			out.println("<p>メールを送りません</p>");
		}
		Page.footer(out);
	}

}
