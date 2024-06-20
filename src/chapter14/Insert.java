package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/insert"})
public class Insert extends HttpServlet {
//  この記述をすることでJSPファイルを開かなくてもここから実行が可能（※実行するファイル名を間違えないようにする）
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("insert.jsp").forward(req,resp);
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

			String name=req.getParameter("name");
			int price=Integer.parseInt(req.getParameter("price"));

//			実行したいSQL文をプリペアードステートメントで準備
//			"?" -> プレースホルダー
			PreparedStatement st = con.prepareStatement(

					"insert into product values(null, ?, ?)");
//			st.setStringメソッド…プリペアードステートメント
//			のプレースホルダーに値を埋め込む（バインド）する
//			第1引数＝プレースホルダ番号
			st.setString(1, name);
			st.setInt(2, price);
//          SQL文を実行（INSERT, UPDATE, DELETE用）
//			変更された件数が返ってくる
			int line = st.executeUpdate();
			if (line>0){
				out.println("追加に成功しました。");
			}

//			データベースとの接続解除（必ず書く！！！！！！！！）
			st.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
