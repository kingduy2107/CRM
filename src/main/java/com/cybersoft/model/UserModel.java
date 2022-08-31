package com.cybersoft.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.connection.MySQLConnection;
import com.cybersoft.pojo.Rolepojo;
import com.cybersoft.pojo.Userpojo;

public class UserModel {
	public List<Userpojo> getUsers() {
		List<Userpojo> users = new ArrayList<>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from account";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Userpojo userpojo = new Userpojo();
				userpojo.setId(result.getLong("id"));
				userpojo.setFullname(result.getString("fullname"));
				userpojo.setEmail(result.getString("email"));
				userpojo.setAddress(result.getString("address"));
				userpojo.setPhone(result.getString("phone"));
				userpojo.setRole_id(result.getLong("role_id"));
				users.add(userpojo);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public boolean insertUsers(Userpojo data) {

		Connection con = MySQLConnection.getConnection();
		String sql = "insert into account(fullname,email,password,address,phone,role_id) values (?,?,?,?,?,?)";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, data.getFullname());
			statement.setString(2, data.getEmail());
			statement.setString(3, data.getPassword());
			statement.setString(4, data.getAddress());
			statement.setString(5, data.getPhone());
			statement.setLong(6, data.getRole_id());

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

	public Userpojo findById(long id) {
		Userpojo userpojo = null;
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from account where id = ?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				userpojo = new Userpojo();
				userpojo.setId(result.getLong("id"));
				userpojo.setFullname(result.getString("fullname"));
				userpojo.setEmail(result.getString("email"));
				userpojo.setPassword(result.getString("password"));
				userpojo.setAddress(result.getString("address"));
				userpojo.setPhone(result.getString("phone"));
				userpojo.setRole_id(result.getLong("role_id"));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userpojo;

	}

	public boolean updateUser(Userpojo data) {
		Connection con = MySQLConnection.getConnection();
		String sql = "update account set fullname=?, email=?, address=?, phone=?, role_id =? where id= ?";
		boolean isSuccess = false;
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, data.getFullname());
			statement.setString(2, data.getEmail());
			statement.setString(3, data.getAddress());
			statement.setString(4, data.getPhone());
			statement.setLong(5, data.getRole_id());
			statement.setLong(6, data.getId());
			int result = statement.executeUpdate();
			System.out.println("result");
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

	public boolean deleteUser(int id) {
		String sql = "delete from account where id = ?";
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

	public Userpojo checkLogin(String email, String password) {
		Userpojo userpojo = null;
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from account where email = ? and password = ?";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				userpojo = new Userpojo();
				userpojo.setId(result.getLong("id"));
				userpojo.setFullname(result.getString("fullname"));
				userpojo.setEmail(result.getString("email"));
				userpojo.setPassword(result.getString("password"));
				userpojo.setAddress(result.getString("address"));
				userpojo.setPhone(result.getString("phone"));
				userpojo.setRole_id(result.getLong("role_id"));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return userpojo;

	}

}
