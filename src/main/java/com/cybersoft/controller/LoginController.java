package com.cybersoft.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.common.Constant;
import com.cybersoft.common.CookieFilter;
import com.cybersoft.model.UserModel;
import com.cybersoft.pojo.Userpojo;

@WebServlet(urlPatterns = { "/login" , "/logout"})
public class LoginController extends HttpServlet {
	UserModel userModel = new UserModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getServletPath();
		switch (action) {
		case "/login":
			req.getRequestDispatcher("/WEB-INF/View/login/login.jsp").forward(req, resp);
			break;
		case "/logout":
			HttpSession session = req.getSession();
			session.removeAttribute("USER_LOGIN");
			resp.sendRedirect(req.getContextPath() + "/login");
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Userpojo userpojo = userModel.checkLogin(email, password);

		if (userpojo == null) {
			req.setAttribute("message", "Sai mật khẩu hoặc email.");
			req.getRequestDispatcher("/WEB-INF/View/login/login.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("USER_LOGIN", userpojo);
			resp.sendRedirect(req.getContextPath() + "/home");

		}

	}
}
