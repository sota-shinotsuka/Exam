package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/all"})
public class All extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);

		try{
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();

//			データベースを使った処理を記述

//			実行したいSQL文をプリペアードステートメントで準備
			PreparedStatement  st=con.prepareStatement(
					"select * from product");
//			SQL文を実行
			ResultSet rs=st.executeQuery();

//			取得した結果を表示
//			結果から1件ずつ取り出すループ
			while (rs.next()) {
//				getIntメソッド…引数で指定した「列」のデータをintで取り出す
				out.println(rs.getInt("id"));
				out.println(":");
//				getStringメソッド…引数で指定した「列」のデータをStringで取り出す
				out.println(rs.getString("name"));
				out.println(":");

				out.println(rs.getInt("price"));
				out.println("<br>");
			}

//			データベースとの接続を解除（必ず書く！！！！！！！！！）
			st.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace(out);
		}

		Page.footer(out);
	}

}
