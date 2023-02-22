package gg.com.project01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;



public class ToDoListOperator {
	String address = "jdbc:postgresql://localhost:5432/zajavka";
	String dbUsername = "postgres";
	String dbPassword = "bingo";

	public void createTask(List<String> data) {
		System.out.println(data);
		if (data.size() > 0) {
			String name = getData(data, 0);
			String description = getData(data, 1);
			String deadlineString = getData(data,2);
			LocalDateTime deadline = LocalDateTime.parse(deadlineString, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
			String priorityString = getData(data, 3);
			int priority = Integer.parseInt(priorityString);
			System.out.println("name = " + name);
			System.out.println("description = " + description);
			System.out.println("deadline = " + deadline);
			System.out.println("priority = " + priority);
		} else {
			System.out.println("No parameters provided for CREATE command.");
		}

	}

	private String getData(List<String> data, int index) {
		if (index < data.size() && data.get(index).contains("=")) {
			return data.get(index).split("=")[1];
		} else {
			return "";
		}
	}
}
