package tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	/**
	 * ページに応じた処理を実行し、フォワード先のJSPファイル名を返却する
	 * @param request
	 * @param respons
	 * @return フォワード先のファイル名
	 * @throws Exception
	 */
	public abstract String execute(
			HttpServletRequest request, HttpServletResponse respons
			)throws Exception;
}
