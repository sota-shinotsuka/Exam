package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URLが「○○○.action」という形だったらサーブレットが実行される
// 例）/chapter23/Search.action
//     /chapter23/Insert.action
@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			// リクエストされたページに応じた処理を実行する
			// リクエストされたURLの1文字目以降を取り出す
			// 例）URL=/chapter23/Search.action
			//  => path=chapter23/Search.action
			String path = req.getServletPath().substring(1);
			// pathの「.a」を「A」に置き換え、さらに「/」に「.」置き換える
			// 例）path = Chapter23/Search.action
			//  => name = chapter23.SearchAction
			String name = path.replace(".a", "A").replace('/', '.');

			// URLをもとにクラス名を取得したことになる

			// クラス名をもとにインスタンスを生成
			// Action action = new chapter23.SearchAction(); と同じこと
			Action action = (Action)Class.forName(name).getDeclaredConstructor().newInstance();
			// executeメソッド実行してフォワード先のJSPファイル名を取得
			String url = action.execute(req, resp);

			// リクエストされたページに応じたJSPにフォワード
			req.getRequestDispatcher(url).forward(req, resp);
		}catch(Exception e){
			// エラー処理
			e.printStackTrace(out);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
