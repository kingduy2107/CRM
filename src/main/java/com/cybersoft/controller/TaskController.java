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

@WebServlet(name = "task", urlPatterns = { Constant.TASKLIST, Constant.TASKCREATE, Constant.TASKDELETE,
		Constant.TASKUPDATE })
public class TaskController extends HttpServlet {
	TaskModel taskModel = new TaskModel();
	UserModel userModel = new UserModel();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		switch (path) {
		case Constant.TASKLIST:
			List<Taskpojo> tasks = taskModel.getTask();
			List<Userpojo> users = userModel.getUsers();
			req.setAttribute("listUsers", users);
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("/WEB-INF/View/task/task.jsp").forward(req, resp);
			break;
		case Constant.TASKCREATE:
			req.getRequestDispatcher("/WEB-INF/View/task/task_add.jsp").forward(req, resp);
			break;
		default:
			break;
		}
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		switch (path) {
		case Constant.PROJECTCREATE:
			Taskpojo taskpojo = new Taskpojo();
			taskpojo.setName_task(req.getParameter("name_task"));
			taskpojo.setDescription_task(req.getParameter("description_task"));
			taskpojo.setStartdate(req.getParameter("startdate").replace("/", "-"));
			taskpojo.setEnddate(req.getParameter("enddate").replace("/", "-"));
			long account_id = Long.parseLong(req.getParameter("account_id"));
			taskpojo.setAccount_id(account_id);
			long status_id = Long.parseLong(req.getParameter("status_id"));
			taskpojo.setStatus_id(status_id);
			long project_id = Long.parseLong(req.getParameter("project_id"));
			taskpojo.setStatus_id(project_id);
			TaskModel model = new TaskModel();
			model.insertTask(taskpojo);
			req.getRequestDispatcher("/WEB-INF/View/task/task_add.jsp").forward(req, resp);
			break;

		default:
			break;
		}

	}
}
