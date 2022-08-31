package com.cybersoft.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.common.Constant;
import com.cybersoft.common.CookieFilter;

@WebFilter(urlPatterns = { "*" })
public class CustomFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		System.out.println("kiem tra filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		Cookie[] cookies = req.getCookies();
		boolean isExistUser = false;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(CookieFilter.COOKIES_USER)) {
				isExistUser = true;
			}
		}
		if (isExistUser) {
			resp.sendRedirect(req.getContextPath() + Constant.HOME);
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
