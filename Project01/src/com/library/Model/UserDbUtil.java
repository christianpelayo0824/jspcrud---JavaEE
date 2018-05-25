package com.library.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.Database.Database;
import com.library.Pojo.User;

public class UserDbUtil {

	private Connection connection = null;
	private User user;

	public UserDbUtil() {
		connection = Database.getConnection();
	}

	public void adddUser(User user) {
		String query = "INSERT INTO users(firstname, lastname, email) VALUES(?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUser() {
		List<User> userList = new ArrayList<>();
		String query = "SELECT * FROM users";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public User getUserById(int userId) {
		String query = "SELECT * FROM users WHERE userid=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void deleteUser(int userId) {
		String query = "DELETE FROM users WHERE userid=?";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			String query = "UPDATE users SET firstname=?, lastname=?, email=? WHERE userid=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getUserId());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
