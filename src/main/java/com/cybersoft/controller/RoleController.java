package com.cybersoft.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.connection.MySQLConnection;

import com.cybersoft.model.RoleModel;
import com.cybersoft.pojo.Rolepojo;

@WebServlet(name = "roles", urlPatterns = { "/roles", "/roles/add" })
public class RoleController extends HttpServlet {
	RoleModel roleModel = new RoleModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/roles":
			List<Rolepojo> roles = roleModel.getRoles();
			req.setAttribute("listRoles", roles);
			req.getRequestDispatcher("/WEB-INF/View/Role/role.jsp").forward(req, resp);
			break;
		case "roles/add":
			req.getRequestDispatcher("/WEB-INF/View/Role/role_add.jsp").forward(req, resp);
			break;
		default:
			break;
		}

	}
}
