package chapter10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();

		out.println("[HelloFilter(pre)]");
		chain.doFilter(request, response);
		out.println("[HelloFilter(post)]");

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
