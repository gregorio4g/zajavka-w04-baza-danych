package gg.com.code;

import java.time.LocalDate;

public class Customer {
	private final	int id;
	private final String userName;
	private final String email;
	private final String name;
	private final String surname;
	private final LocalDate dateOfBirth;
	private final String telephoneNumber;

	public Customer(int id, String userName, String email, String name, String surname, LocalDate dateOfBirth, String telephoneNumber) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.telephoneNumber = telephoneNumber;
	}

	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	public String getUserName() {
		return userName;
	}

	@SuppressWarnings("unused")
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	public String getSurname() {
		return surname;
	}

	@SuppressWarnings("unused")
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	@SuppressWarnings("unused")
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", telephoneNumber='" + telephoneNumber + '\'' +
				'}';
	}
}
