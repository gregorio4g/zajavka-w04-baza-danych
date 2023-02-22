package gg.com.project01;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ToDoListOperator {
	private final String address = "jdbc:postgresql://localhost:5432/zajavka";
	private final String dbUsername = "postgres";
	private final String dbPassword = "bingo";
	String insertQuery = "INSERT INTO TO_DO_LIST (DESCRIPTION, DEADLINE, PRIORITY, NAME) " +
			"VALUES (?, ?, ?, ?)";
	String updateQuery = "UPDATE TO_DO_LIST SET " +
			"DESCRIPTION = ?, " +
			"DEADLINE = ?, " +
			"PRIORITY = ? " +
			"WHERE NAME = ?";

	public void createTask (List<String> data) {
		createUpdateTask(insertQuery, data);
	}
	public void updateTask(List<String> data) {
		createUpdateTask(updateQuery, data);
	}

	private void createUpdateTask(String query, @NotNull List<String> data) {
		if (data.size() > 0) {
			String name = getData(data, 0); // TODO check if name is not empty
			String description = getData(data, 1);
			String deadlineString = getData(data, 2);
			LocalDateTime deadline = LocalDateTime.parse(deadlineString, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")); // TODO try-catch: if exception then empty
			String priorityString = getData(data, 3);
			int priority = Integer.parseInt(priorityString); // TODO try-catch it has to be number
			try (Connection connection = DriverManager.getConnection(address, dbUsername, dbPassword);
					 PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, description);
				statement.setTimestamp(2, Timestamp.valueOf(deadline));
				statement.setInt(3, priority);
				statement.setString(4, name);
				int count = statement.executeUpdate();
				System.out.println(count + " record(s) changed");
			} catch (SQLException e) {
				System.err.println("Exception: " + e.getMessage());
				System.out.println(e.getSQLState());
				System.out.println(e.getErrorCode());
			}
		} else {
			System.out.println("No parameters provided for command.");
		}


	}

	private String getData(@NotNull List<String> data, int index) {
		if (index < data.size() && data.get(index).contains("=")) {
			return data.get(index).split("=")[1];
		} else {
			return "";
		}
	}


	public void read1(List<String> data) {

	}
}
