// パッケージ（ディレクトリ）の指定
package chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// クラスと対応するURLを指定
// パッケージ名とクラス名になるようにする
@WebServlet(urlPatterns={"/chapter3/hello"})
/**
 * Helloクラス
 * HttpServletのサブクラス
 * @author s_shinotsuka
 *
 */
public class Hello extends HttpServlet {
	/**
	 * doGetメソッド
	 * GETでのリクエストに対するレスポンスを定義
	 *   GET...通常のデータ（画面）取得の通信
	 *
	 * @param HttpServletRequest request : 送信された情報    // @param = 引数
	 * @param HttpServletResponse response : ブラウザに返す情報
	 *
	 */
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException,IOException {

//      レスポンスに書き込むためのライターを取得
		PrintWriter out=response.getWriter();
		out.println("矢島翔");
		out.println(new java.util.Date());
	}

	/**
	 * doPostメソッド
	 * POSTでのリクエストに対するレスポンスを定義
	 * 　POST...入力データを送信するときの通信
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		super.doPost(req, resp);
	}


}
