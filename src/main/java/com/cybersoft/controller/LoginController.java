package com.cybersoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.common.Constant;
import com.cybersoft.common.CookieFilter;
import com.cybersoft.model.UserModel;
import com.cybersoft.pojo.Userpojo;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	UserModel userModel = new UserModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		req.getRequestDispatcher("/WEB-INF/View/login/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Userpojo userpojo = userModel.checkLogin(email, password);

		if (userpojo != null) {
			Cookie cookie = new Cookie(CookieFilter.COOKIES_USER, userpojo.getFullname());
			cookie.setMaxAge(600);
			resp.addCookie(cookie);
			resp.sendRedirect(req.getContextPath() + Constant.HOME);
		} else {
			resp.sendRedirect(req.getContextPath() + Constant.ERROR);
		}

	}
}
