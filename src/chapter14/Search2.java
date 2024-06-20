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

@WebServlet(urlPatterns={"/chapter14/search2"})
public class Search2 extends HttpServlet {
//  この記述をすることでJSPファイルを開かなくてもここから実行が可能（※実行するファイル名を間違えないようにする）
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("search2.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
					"java:/comp/env/jdbc/book");

			Connection con = ds.getConnection();

//			データベースを使った処理を実行

			String keyword=req.getParameter("keyword");

//			実行したいSQL文をプリペアードステートメントで準備
//			"?" -> プレースホルダー
			PreparedStatement st = con.prepareStatement(
//					name = ? -> 完全一致検索
//					シングルクォーテーション -> SQLにとっての文字列
					"select * from product where name = '"+keyword+"'");
//			st.setStringメソッド…プリペアードステートメント
//			のプレースホルダーに値を埋め込む（バインド）する
//			第1引数＝プレースホルダ番号
//			st.setString(1, keyword);
//			SQL文を実行した結果をリザルトセットに格納
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getInt("price"));
				out.println("<br>");
			}

			st.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
