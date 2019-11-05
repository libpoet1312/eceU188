package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import beans.User;

public class DBUtils {

	public static User findUser(Connection conn, String email, String password) throws SQLException {

		String sql = "Select a.email, a.password, a.username from users a " //
				+ " where a.email = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, email);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {

			User user = new User();
			user.setUserName(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			
			user.setPassword(password);
			
			return user;
		}
		return null;
	}

	public static User findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.username, a.Password from users a "//
				+ " where a.username = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);

			return user;
		}
		return null;
	}

}
