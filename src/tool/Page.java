package tool;

import java.io.PrintWriter;

/**
 * Pageクラス
 * ページに対して共通に行う処理をまとめたクラス
 * @author s_shinotsuka
 *
 */
public class Page {

	/**
	 * headerメソッド
	 * 先頭に出力するHTML（タイトルを指定）
	 * @param out
	 * @param title
	 */
	public static void header(PrintWriter out, String title) {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body>");
	}

	/**
	 * headerメソッド
	 * 先頭に出力するHTML
	 * @param out
	 */
	public static void header(PrintWriter out){
		header(out, "Servlet/JSP Sample Programs");
	}

	/**
	 * footerメソッド
	 * 末尾に出力するHTML
	 * @param out
	 */
	public static void footer(PrintWriter out){
		out.println("</body>");
		out.println("</html>");
	}
}
