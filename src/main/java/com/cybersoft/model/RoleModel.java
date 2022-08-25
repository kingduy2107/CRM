package com.cybersoft.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.connection.MySQLConnection;
import com.cybersoft.pojo.Rolepojo;

public class RoleModel {
	public List<Rolepojo> getRoles() {
		List<Rolepojo> roles = new ArrayList<>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from roles";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Rolepojo rolepojo = new Rolepojo();
				rolepojo.setRole_id(result.getLong("role_id"));
				rolepojo.setRole_name(result.getString("role_name"));
				rolepojo.setDescription(result.getString("description"));
				roles.add(rolepojo);
			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}

}
