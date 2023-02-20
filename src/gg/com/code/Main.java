package gg.com.code;

import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.List;

public class Main {
	public static void main(@NotNull String[] args) {
		// CRUD - create, read, update, delete
		// DBMS - PostgreSQL, Oracle, MySQL, MS SQL Server, IBM Db2, MS Access, SQLite
		// Database Server - Client
		// Czym są dane?

		// ID		| Imię     	| Nazwisko		| City
		// 		1	| Karol			| Rogowski		| Wrocław
		// 		2	| Karol			| Rogowski		|
		// 		3 | Bartosz		| Kowalczyk		| Zakopane
		// 		4	| Agnieszka	| Zajavkowa		| Gdynia

		// NoSQL

		// SQL - Structured Query Language
		// JDBC - Java DataBase Connectivity
		// JPA - Java Persistence API
		// RDBMS - Relational DataBase Management System

		// Data integrity
		// - entity integrity
		// - domain integrity
		// - referential integrity
		// - user-defined integrity

		// Constraints
		// - NOT NULL
		// - UNIQUE
		// - DEFAULT
		// - CHECK (IS JSON)
		// - PRIMARY KEY
		// - FOREIGN KEY

		/* typy danych PostgeSQL
		 * name					| rozmiar		| zakres									| komentarz
		 * ------------------------------------------------------------------
		 * boolean				| 1 bajt		| false , true						| może też być null
		 * --
		 * smallint			| 2 bajty		| -32768, 32767						| integer o małym zakresie danych
		 * integer				| 4 bajty		| -2147483648, 2147483647	| najczęściej używane
		 * bigint				| 8 bajtów	|													| integer o dużym zakresie danych
		 * real					| 4 bajty		| dokładność 6 cyfr po ,	|
		 * numeric(p,s)	| zmienny
		 * --
		 * char(n)				| 					| ciąg znaków długości n dopełniona spacjami
		 * varchar(n)		|						| nie dopełni spacjami
		 * text					|						| nieograniczona długość
		 * --
		 * date											| tylko data
		 * time											| tylko czas
		 * timestamp									| data i czas
		 * timestamp with timezone		| przechowuje datę i czas z uwzględnieniem strefy czasowej
		 * */

		String address = "jdbc:postgresql://localhost:5432/zajavka";
		String dbUsername = "postgres";
		String dbPassword = "bingo";

//		String username = "ntinner27";
		String username = "whatever' or 1=1 or USER_NAME = 'WhateverAgain";

		String query1 = "DELETE FROM OPINION WHERE CUSTOMER_ID " +
				"IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = ?)";
		String query2 = "DELETE FROM PURCHASE WHERE CUSTOMER_ID " +
				"IN (SELECT ID FROM CUSTOMER WHERE USER_NAME = ?)";
		String query3 = "DELETE FROM CUSTOMER WHERE USER_NAME = ?";

		String query4 = "SELECT * FROM CUSTOMER";

		String query5 = "SELECT * FROM CUSTOMER WHERE NAME LIKE ?";
		String parameter = "%me%";

		try (Connection connection = DriverManager.getConnection(address, dbUsername, dbPassword);
				 Statement statement = connection.createStatement();
				 ResultSet resultSet = statement.executeQuery(query4);

				 PreparedStatement statement1 = connection.prepareStatement(query1);
				 PreparedStatement statement2 = connection.prepareStatement(query2);
				 PreparedStatement statement3 = connection.prepareStatement(query3);

				 PreparedStatement statement5 = connection.prepareStatement(query5)
		) {
			statement1.setString(1, username);
			int count1 = statement1.executeUpdate();
			System.out.println("Changed " + count1 + " rows from OPINION");

			statement2.setString(1, username);
			int count2 = statement2.executeUpdate();
			System.out.println("Changed " + count2 + " rows from PURCHASE");

			statement3.setString(1, username);
			int count3 = statement3.executeUpdate();
			System.out.println("Changed " + count3 + " rows from CUSTOMER");

			ResultSetMetaData metaData = resultSet.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i) + " ");
				System.out.println(metaData.getColumnTypeName(i));
			}

			statement5.setString(1, parameter);
			try (ResultSet resultSet5 = statement5.executeQuery()) {
				List<Customer> customers = CustomerMapper.addToCustomer(resultSet5);
				customers.forEach(System.out::println);
			}
		} catch (SQLException e) {
			System.err.println("Exception: " + e.getMessage());
			System.out.println(e.getSQLState());
			System.out.println(e.getErrorCode());
		}

	}
}