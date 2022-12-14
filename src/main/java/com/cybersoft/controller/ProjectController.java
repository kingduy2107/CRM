package com.cybersoft.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.common.Constant;
import com.cybersoft.model.ProjectModel;
import com.cybersoft.model.RoleModel;
import com.cybersoft.model.UserModel;
import com.cybersoft.pojo.Projectpojo;
import com.cybersoft.pojo.Userpojo;

@WebServlet(name = "project", urlPatterns = { Constant.PROJECT, Constant.PROJECTCREATE, Constant.PROJECTDELETE, Constant.PROJECTVIEW,
		Constant.PROJECTUPDATE })
public class ProjectController extends HttpServlet {

	ProjectModel projectModel = new ProjectModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		UserModel userModel = new UserModel();
		List<Userpojo> users = userModel.getUsers();
		req.setAttribute("listUsers", users);
		HttpSession session = req.getSession();
		Userpojo userpojo = (Userpojo) session.getAttribute("USER_LOGIN");

		switch (path) {
		case Constant.PROJECT:
			if (userpojo.getRole_id() == 1 || userpojo.getRole_id() == 2) {
				List<Projectpojo> projects = projectModel.getProject();
				req.setAttribute("listProject", projects);
				req.getRequestDispatcher("/WEB-INF/View/Project/project.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + Constant.ERROR);
			}
			break;
		case Constant.PROJECTCREATE:
			if (userpojo.getRole_id() == 1 || userpojo.getRole_id() == 2) {
				req.getRequestDispatcher("/WEB-INF/View/Project/project_add.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + Constant.ERROR);
			}
			break;
		case Constant.PROJECTUPDATE:
			if (userpojo.getRole_id() == 1 || userpojo.getRole_id() == 2) {
				String idStr = req.getParameter("id");
				long id = Long.parseLong(idStr);
				ProjectModel pm = new ProjectModel();
				Projectpojo project = pm.findById(id);
				req.setAttribute("project", project);
				req.getRequestDispatcher("/WEB-INF/View/Project/project_edit.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + Constant.ERROR);
			}
			break;
		case Constant.PROJECTDELETE:
			if (userpojo.getRole_id() == 1 || userpojo.getRole_id() == 2) {
				int idDelete = Integer.parseInt(req.getParameter("id"));
				projectModel.deleteProject(idDelete);
				resp.sendRedirect(req.getContextPath() + Constant.PROJECT);
			} else {
				resp.sendRedirect(req.getContextPath() + Constant.ERROR);
			}
			break;
		case Constant.PROJECTVIEW:
			req.getRequestDispatcher("/WEB-INF/View/Project/view.jsp").forward(req, resp);
			break;
		default:
			break;

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		switch (path) {
		case Constant.PROJECT:
			List<Projectpojo> projects = projectModel.getProject();
			req.setAttribute("listProject", projects);
			req.getRequestDispatcher("/WEB-INF/View/Project/project.jsp").forward(req, resp);
			break;
		case Constant.PROJECTCREATE:
			Projectpojo projectpojo = new Projectpojo();
			projectpojo.setName_project(req.getParameter("name_project"));
			projectpojo.setDescription_project(req.getParameter("description_project"));
			projectpojo.setStartdate(req.getParameter("startdate").replace("/", "-"));
			projectpojo.setEnddate(req.getParameter("enddate").replace("/", "-"));
			long account_id = Long.parseLong(req.getParameter("account_id"));
			projectpojo.setAccount_id(account_id);
			ProjectModel model = new ProjectModel();
			model.insertProject(projectpojo);
			req.getRequestDispatcher("/WEB-INF/View/Project/project_add.jsp").forward(req, resp);
			break;
		case Constant.PROJECTUPDATE:
			Projectpojo projectedit = new Projectpojo();
			projectedit.setName_project(req.getParameter("name_project"));
			projectedit.setDescription_project(req.getParameter("description_project"));
			projectedit.setStartdate(req.getParameter("startdate").replace("/", "-"));
			projectedit.setEnddate(req.getParameter("enddate").replace("/", "-"));
			long account_id1 = Long.parseLong(req.getParameter("account_id"));
			projectedit.setAccount_id(account_id1);
			long id = Long.parseLong(req.getParameter("id"));
			projectedit.setId(id);
			ProjectModel PM = new ProjectModel();
			PM.updateProject(projectedit);
			req.getRequestDispatcher("/WEB-INF/View/Project/project_edit.jsp").forward(req, resp);
			break;
		default:
			break;
		}

	}
}
