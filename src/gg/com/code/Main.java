package gg.com.code;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
		String username = "postgres";
		String password = "bingo";

		String query1 = "INSERT INTO PRODUCER(ID, PRODUCER_NAME, ADDRESS)"
				+ "VALUES (6, 'Zajavka Group 6', 'Zajavkowa 15, Warszawa')";
		String query2 = "UPDATE PRODUCER SET ADDRESS = 'Nowy Adres Siedziby' WHere ID = 1";
		String query3 = "DELETE FROM PRODUCER WHERE ID = 2";

		String query4 = "SELECT * FROM PRODUCER";
		try (Connection connection = DriverManager.getConnection(address, username, password);
				 Statement statement = connection.createStatement();
				 ResultSet resultSet = statement.executeQuery(query4)
		) {
//			int i = statement.executeUpdate(query1);
//			System.out.println(i);
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}

	}
}