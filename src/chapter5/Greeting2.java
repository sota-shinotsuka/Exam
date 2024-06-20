package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter5/greeting2"})
public class Greeting2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();

//		リクエストパラメータの文字コードを指定
		req.setCharacterEncoding("UTF-8");

//		getParameterメソッド...リクエストパラメータからデータを取得する
//		　POSTの場合は目に見えない情報として送信される
		String user=req.getParameter("user");

		Page.header(out);
		out.println("<p>こんにちは、"+ user +"さん！</p>");
		Page.footer(out);
	}

}
