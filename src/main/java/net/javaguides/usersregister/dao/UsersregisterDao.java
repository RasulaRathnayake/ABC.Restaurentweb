
package net.javaguides.usersregister.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

import net.javaguides.usersregister.model.Usersregister;


public class UsersregisterDao {

	private static Object usersregister;

	public static int registerusers(Usersregister userstegister) throws ClassNotFoundException, SQLException {
	String INSERT_USERS_SQL = "INSERT INTO usersregister" +
			"(user_id, name, email, password, role) VALUES " +
			" (?, ?, ?, ?, ?);";

	int result = 0;

	Class.forName("com.mysql.jbdc.Driver");

	try (Connection connection = DriverManager
	.getConnection("jdbc:mysql://localhost:3306/?user=root");

	// Step 2:Create a statement using connection object
	PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, net.javaguides.usersregister.model.Usersregister.getUser_id());
		preparedStatement.setString(2, net.javaguides.usersregister.model.Usersregister.getName());
		preparedStatement.setString(2, net.javaguides.usersregister.model.Usersregister.getEmail());
		preparedStatement.setString(2, net.javaguides.usersregister.model.Usersregister.getPassword());
		preparedStatement.setString(2, net.javaguides.usersregister.model.Usersregister.getRole());

		System.out.println(preparedStatement);
		// Step 3: Execute the query or update query
		result = preparedStatement.executeUpdate();

	}catch (SQLDataException e) {
		// process sequel exception
		e.printStackTrace();
	}
	return result;
    }

	public static Object getUsersregister() {
		return usersregister;
	}

	public static void setUsersregister(Object usersregister) {
		UsersregisterDao.usersregister = usersregister;
	}
	public void usersregister(Usersregister usersregister) {
	    // Implementation code to save the usersregister object to the database
	}

}

