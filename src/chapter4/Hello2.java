package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter4/hello2"})	// annotation
public class Hello2 extends HttpServlet {		// Servletを作ったらサーバーを再始動して実行する

	@Override
	protected void doGet (
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException {
//		文字コードをUTF-8に指定
		response.setContentType("text/plain; charset=UTF-8");

		PrintWriter out=response.getWriter();
		out.println("Hello!");
		out.println("こんにちは！");
//		out.println("你好！");
		out.println(new java.util.Date());
	}

}
