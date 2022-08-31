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
import com.cybersoft.pojo.Userpojo;

public class ProjectModel {

	public List<Projectpojo> getProject() {
		List<Projectpojo> projects = new ArrayList<>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from project";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Projectpojo projectpojo = new Projectpojo();
				projectpojo.setId(result.getLong("id"));
				projectpojo.setName_project(result.getString("name_project"));
				projectpojo.setDescription_project(result.getString("description_project"));
				projectpojo.setStartdate(result.getString("startdate"));
				projectpojo.setEnddate(result.getString("enddate"));
				projectpojo.setAccount_id(result.getLong("account_id"));
				projects.add(projectpojo);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projects;
	}

	public boolean insertProject(Projectpojo data) {

		Connection con = MySQLConnection.getConnection();
		String sql = "insert into project(name_project,description_project,startdate,enddate,account_id) values (?,?,?,?,?)";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, data.getName_project());
			statement.setString(2, data.getDescription_project());
			statement.setString(3, data.getStartdate());
			statement.setString(4, data.getEnddate());
			statement.setLong(5, data.getAccount_id());
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
	
	
	public Projectpojo findById(long id) {
		Projectpojo projectpojo = null;
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from project where id = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				projectpojo = new Projectpojo();
				projectpojo.setId(result.getLong("id"));
				projectpojo.setName_project(result.getString("name_project"));
				projectpojo.setDescription_project(result.getString("description_project"));
				projectpojo.setStartdate(result.getString("startdate"));
				projectpojo.setEnddate(result.getString("enddate"));
				projectpojo.setAccount_id(result.getLong("account_id"));
				
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return projectpojo;

	}
	
	
	
	public boolean updateProject(Projectpojo data) {
		Connection con = MySQLConnection.getConnection();
		String sql = "update project set name_project=?, description_project=?, startdate=?, enddate=?, account_id =? where id= ?";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, data.getName_project());
			statement.setString(2, data.getDescription_project());
			statement.setString(3, data.getStartdate());
			statement.setString(4, data.getEnddate());
			statement.setLong(5, data.getAccount_id());
			statement.setLong(6, data.getId());
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
	
	public boolean deleteProject(int id) {
		String sql = "delete from project where id = ?";
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
