package com.customercrudapplication.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First Name is mandatory")
	@Size(min = 3, max = 15, message = "Your Firstname having minimum 3 and maximum 15 characters")
	private String firstName;

	@NotEmpty(message = "Last Name is mandatory")
	@Size(min = 3, max = 15, message = "Your Lastname having minimum 3 and maximum 15 characters")
	private String lastName;

	@NotEmpty(message = "Date of Birth is mandatory")
	private String dateOfBirth;

	@Size(min = 10, max = 12, message = "Your Mobile no having minimum 10 and maximum 12 numbers")
	@NotEmpty(message = "Mobile is mandatory")
	private String mobile;

	@NotEmpty(message = "Address1 is mandatory")
	@Size(min = 10, max = 150, message = "Your Address having minimum 10 and maximum 150 characters")
	private String address1;

	@Size(min = 0, max = 150, message = "Your Address having minimum 0 and maximum 150 characters")
	private String address2;

	@NotNull(message = "Age is mandatory")
	@Min(18)
	@Max(200)
	private int age;

	@NotNull(message = "Gender is mandatory")
	@Column(columnDefinition = " TINYINT(2) NOT NULL COMMENT '1 for Male, 2 for Female'")
	private int gender;

	@NotEmpty(message = "Email is mandatory")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid mail")
	private String email;

	public static List<Customer> result;

	public static String fields[] = { "firstName", "lastName", "dateOfBirth", "mobile", "address1", "address2", "age",
			"gender", "email" };

	public static String tableHeading[] = { "ID", "Name", "Date of Birth", "Mobile", "Address", "Gender", "Actions" };

}