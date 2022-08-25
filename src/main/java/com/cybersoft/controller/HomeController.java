package com.cybersoft.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.connection.MySQLConnection;


@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(Connection conn = MySQLConnection.getConnection()){
			if(conn != null) {
				System.out.println("Connect thành công");
			}
			else {
				System.out.println("fail");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/View/Home/home.jsp").forward(req, resp);
	}
}
