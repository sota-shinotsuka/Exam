package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/forward"})
public class Forward extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String user=req.getParameter("user");

//		送信されたデータに対する任意の処理を記述

//		redirectというページにリダイレクト
		resp.sendRedirect("redirect");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		任意の処理を記述
		int x = 10;
		int y = 20;
		int z = x + y;

//		jspに、data-zという名前で変数zの値を渡す
		req.setAttribute("data-z", z);

//		forward.jspの内容を出力
		req.getRequestDispatcher("forward.jsp").forward(req, resp);
	}

}
