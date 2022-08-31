package com.cybersoft.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.common.Constant;
import com.cybersoft.model.ProjectModel;
import com.cybersoft.model.TaskModel;
import com.cybersoft.model.UserModel;
import com.cybersoft.pojo.Projectpojo;
import com.cybersoft.pojo.Taskpojo;
import com.cybersoft.pojo.Userpojo;

@WebServlet(name = "tasks", urlPatterns = { Constant.TASKLIST, Constant.TASKCREATE, Constant.TASKDELETE,
		Constant.TASKUPDATE })
public class TaskController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		TaskModel taskModel = new TaskModel();
		UserModel userModel = new UserModel();
		ProjectModel projectModel = new ProjectModel();
		List<Projectpojo> project = projectModel.getProject();
		req.setAttribute("listProject", project);
		List<Userpojo> users = userModel.getUsers();
		req.setAttribute("listUsers", users);

		switch (path) {
		case Constant.TASKLIST:
			List<Taskpojo> tasks = taskModel.getTask();
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("/WEB-INF/View/task/task.jsp").forward(req, resp);
			break;
		case Constant.TASKCREATE:
			req.getRequestDispatcher("/WEB-INF/View/task/task_add.jsp").forward(req, resp);
			break;
		case Constant.TASKUPDATE:
			String idStr = req.getParameter("id_task");
			long id = Long.parseLong(idStr);
			TaskModel pm = new TaskModel();
			Taskpojo task = pm.findById(id);
			req.setAttribute("task", task);
			req.getRequestDispatcher("/WEB-INF/View/task/task_edit.jsp").forward(req, resp);
			break;
		case Constant.TASKDELETE:
			int idDelete = Integer.parseInt(req.getParameter("id_task"));
			taskModel.deleteTask(idDelete);
			resp.sendRedirect(req.getContextPath() + Constant.TASKLIST);
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
		TaskModel taskModel = new TaskModel();
		UserModel userModel = new UserModel();
		ProjectModel projectModel = new ProjectModel();
		List<Projectpojo> project = projectModel.getProject();
		req.setAttribute("listProject", project);
		List<Userpojo> users = userModel.getUsers();
		req.setAttribute("listUsers", users);
		List<Taskpojo> tasks = taskModel.getTask();
		req.setAttribute("listTasks", tasks);
		switch (path) {
		case Constant.TASKLIST:
			req.getRequestDispatcher("/WEB-INF/View/task/task.jsp").forward(req, resp);
			break;
		case Constant.TASKCREATE:
			Taskpojo taskpojo = new Taskpojo();
			long project_id = Long.parseLong(req.getParameter("project_id"));
			taskpojo.setProject_id(project_id);
			taskpojo.setName_task(req.getParameter("name_task"));
			taskpojo.setStartdate(req.getParameter("startdate").replace("/", "-"));
			taskpojo.setEnddate(req.getParameter("enddate").replace("/", "-"));
			long account_id = Long.parseLong(req.getParameter("account_id"));
			taskpojo.setAccount_id(account_id);
			long status_id = Long.parseLong(req.getParameter("status_id"));
			taskpojo.setStatus_id(status_id);
			TaskModel model = new TaskModel();
			model.insertTask(taskpojo);
			req.getRequestDispatcher("/WEB-INF/View/task/task_add.jsp").forward(req, resp);
			break;
		case Constant.TASKUPDATE:
			Taskpojo taskedit = new Taskpojo();
			long project_id2 = Long.parseLong(req.getParameter("project_id"));
			taskedit.setProject_id(project_id2);
			taskedit.setName_task(req.getParameter("name_task"));
			taskedit.setStartdate(req.getParameter("startdate").replace("/", "-"));
			taskedit.setEnddate(req.getParameter("enddate").replace("/", "-"));
			long account_id2 = Long.parseLong(req.getParameter("account_id"));
			taskedit.setAccount_id(account_id2);
			long status_id2 = Long.parseLong(req.getParameter("status_id"));
			taskedit.setStatus_id(status_id2);
			long id_task = Long.parseLong(req.getParameter("id_task"));
			taskedit.setId_task(id_task);
			TaskModel TM = new TaskModel();
			TM.updateTask(taskedit);
			req.getRequestDispatcher("/WEB-INF/View/task/task_edit.jsp").forward(req, resp);
			break;
		default:
			break;
		}

	}
}
