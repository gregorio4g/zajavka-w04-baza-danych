package gg.com.project01;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String command = "run";
		ToDoListOperator toDo = new ToDoListOperator();
		while(!command.equalsIgnoreCase("quit")) {
			command = scanner.nextLine();
			List<String> commandList = commandToList(command);
			switch (commandList.get(0).toUpperCase()) {
				case "CREATE":
					if (commandList.size() > 1) {
						toDo.createTask(commandList.subList(1, commandList.size()));
					}
					break;
			}
		}
	}

	@NotNull
	@Contract("_ -> new")
	private static List<String> commandToList(@NotNull String command) {
		String[] split = command.split(";");
		return new ArrayList<>(List.of(split));
	}
}
