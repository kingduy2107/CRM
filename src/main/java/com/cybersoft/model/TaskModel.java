package com.cybersoft.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.connection.MySQLConnection;
import com.cybersoft.pojo.Projectpojo;
import com.cybersoft.pojo.Rolepojo;
import com.cybersoft.pojo.Taskpojo;
import com.cybersoft.pojo.Userpojo;

public class TaskModel {
	public List<Taskpojo> getTask() {
		List<Taskpojo> tasks = new ArrayList<>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from tasks";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Taskpojo taskpojo = new Taskpojo();
				taskpojo.setId_task(result.getLong("id_task"));
				taskpojo.setName_task(result.getString("name_task"));
				taskpojo.setStartdate(result.getString("startdate"));
				taskpojo.setEnddate(result.getString("enddate"));
				taskpojo.setAccount_id(result.getLong("account_id"));
				taskpojo.setStatus_id(result.getLong("status_id"));
				taskpojo.setProject_id(result.getLong("project_id"));
				tasks.add(taskpojo);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	public boolean insertTask(Taskpojo data) {

		Connection con = MySQLConnection.getConnection();
		String sql = "insert into tasks(project_id,name_task,startdate,enddate,account_id,status_id) values (?,?,?,?,?,?)";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, data.getProject_id());
			statement.setString(2, data.getName_task());
			statement.setString(3, data.getStartdate());
			statement.setString(4, data.getEnddate());
			statement.setLong(5, data.getAccount_id());
			statement.setLong(6, data.getStatus_id());

			int result = statement.executeUpdate();
			System.out.println("task");
			con.close();
			if (result > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess;

	}

	public Taskpojo findById(long id) {
		Taskpojo taskpojo = null;
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from tasks where id_task = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				taskpojo = new Taskpojo();
				taskpojo.setId_task(result.getLong("id_task"));
				taskpojo.setName_task(result.getString("name_task"));
				taskpojo.setStartdate(result.getString("startdate"));
				taskpojo.setEnddate(result.getString("enddate"));
				taskpojo.setAccount_id(result.getLong("account_id"));
				taskpojo.setStatus_id(result.getLong("status_id"));
				taskpojo.setProject_id(result.getLong("project_id"));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return taskpojo;

	}
	
	
	public boolean updateTask(Taskpojo data) {
		Connection con = MySQLConnection.getConnection();
		String sql = "update tasks set  project_id=?, name_task=?, startdate=?, enddate=?, account_id =?, status_id=? where id_task= ?";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, data.getProject_id());
			statement.setString(2, data.getName_task());
			statement.setString(3, data.getStartdate());
			statement.setString(4, data.getEnddate());
			statement.setLong(5, data.getAccount_id());
			statement.setLong(6, data.getStatus_id());
			statement.setLong(7, data.getId_task());
			int result = statement.executeUpdate();
			con.close();
			if (result > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isSuccess;

	}
	

	public boolean deleteTask(int id) {
		String sql = "delete from tasks where id_task = ?";
		Connection con = MySQLConnection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setLong(1, id);
			int result = statement.executeUpdate();
			con.close();

			if (result > 0) {
				System.out.println("delete success!!");
			} else {
				System.out.println("Fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
