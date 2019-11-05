package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.User;
import connector.*;
import utils.DBUtils;

public class UserDAO {
	public int registerUser(User user) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users"
				+ "  (username, email, password) VALUES "
				+ " (?, ?, ?);";

		int result = 0;

		System.out.println("EDW");
		try (Connection conn = ConnectionUtils.getConnection(); 
				
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) 
		{	
			
			if (DBUtils.findUser(conn, user.getUserName()) != null) {
				//user already exists
				return -1;
			};
			
			
			// preparedStatement.setInt(1, 1);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return 1;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
