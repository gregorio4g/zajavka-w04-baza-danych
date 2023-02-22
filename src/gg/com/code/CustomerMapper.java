package gg.com.code;

import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
	@NotNull
	public static List<Customer> addToCustomer(ResultSet resultSet) {
		List<Customer> result	= new ArrayList<>();
		try {
			while (resultSet.next()) {
				result.add(new Customer(
						resultSet.getInt("id"),
						resultSet.getString("user_name"),
						resultSet.getString("email"),
						resultSet.getString("name"),
						resultSet.getString("surname"),
						resultSet.getDate("date_of_birth").toLocalDate(),
						resultSet.getString("telephone_number")
				));
			}
		} catch (Exception e) {
			System.err.println("Error while mapping resultSet to Customer list: " + e.getMessage());
		}
		return result;
	}
}
