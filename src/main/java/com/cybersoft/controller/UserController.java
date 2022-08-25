package com.cybersoft.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.common.Constant;
import com.cybersoft.connection.MySQLConnection;
import com.cybersoft.model.RoleModel;
import com.cybersoft.model.UserModel;
import com.cybersoft.pojo.Rolepojo;
import com.cybersoft.pojo.Userpojo;

@WebServlet(name = "user", urlPatterns = { Constant.USERLIST, Constant.USERDELETE, Constant.USERUPDATE,
		Constant.USERCREATE })
public class UserController extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		RoleModel roleModel = new RoleModel();
		String path = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		List<Rolepojo> roles = roleModel.getRoles();
		req.setAttribute("listRoles", roles);
		switch (path) {
		case Constant.USERLIST:
			List<Userpojo> users = userModel.getUsers();
			
			req.setAttribute("listUsers", users);
			req.getRequestDispatcher("/WEB-INF/View/Users/user.jsp").forward(req, resp);
			break;
		case Constant.USERCREATE:
			req.getRequestDispatcher("/WEB-INF/View/Users/user_add.jsp").forward(req, resp);
			break;
		case Constant.USERUPDATE:
			String idStr = req.getParameter("id");
			long id = Long.parseLong(idStr);
			UserModel um = new UserModel();
			Userpojo user = um.findById(id);
			System.out.println(id);
			req.setAttribute("user", user);
			req.getRequestDispatcher("/WEB-INF/View/Users/user_edit.jsp").forward(req, resp);
			break;
		case Constant.USERDELETE:
			int idDelete= Integer.parseInt(req.getParameter("id"));
			userModel.deleteUser(idDelete);
			resp.sendRedirect(req.getContextPath() + "/listusers");
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String path = req.getServletPath();
		UserModel userModel = new UserModel();
		RoleModel roleModel = new RoleModel();
		switch (path) {
		case Constant.USERLIST:
			List<Userpojo> users = userModel.getUsers();
			List<Rolepojo> roles = roleModel.getRoles();
			req.setAttribute("listRoles", roles);
			req.setAttribute("listUsers", users);
			req.getRequestDispatcher("/WEB-INF/View/Users/user.jsp").forward(req, resp);
			break;

		case Constant.USERCREATE:
			Userpojo userpojo = new Userpojo();
			userpojo.setFullname(req.getParameter("fullname"));
			userpojo.setEmail(req.getParameter("email"));
			userpojo.setPassword(req.getParameter("password"));
			userpojo.setAddress(req.getParameter("address"));
			userpojo.setPhone(req.getParameter("phone"));
			long role_id = Long.parseLong(req.getParameter("role_id"));
			userpojo.setRole_id(role_id);
			UserModel userinsert = new UserModel();
			userinsert.insertUsers(userpojo);
			req.getRequestDispatcher("/WEB-INF/View/Users/user_add.jsp").forward(req, resp);
			break;
		case Constant.USERUPDATE:
			Userpojo useredit = new Userpojo();
			useredit.setFullname(req.getParameter("fullname"));
			useredit.setEmail(req.getParameter("email"));
			useredit.setAddress(req.getParameter("address"));
			useredit.setPhone(req.getParameter("phone"));
			long role_id1 = Long.parseLong(req.getParameter("role_id"));
			useredit.setRole_id(role_id1);
			long id = Long.parseLong(req.getParameter("id"));
			useredit.setId(id);
			UserModel UM = new UserModel();
			UM.updateUser(useredit);
			req.getRequestDispatcher("/WEB-INF/View/Users/user_edit.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
}
