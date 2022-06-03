package service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.User;

public class UserServiceTest {

	UserService userService;
	String firstName;
	String lastName;
	String email;
	String password;
	String repeatPassword;
	
	@BeforeEach
	public void persiapan() {
		//Arrange
		userService = new UserServiceImpl();
		firstName = "Intan";
		lastName  = "Juniar";
		email     = "Intan.juniar@gmail.com";
		password  = "cacicuce";
		repeatPassword = "lalalalo";
	}
	
//	Green Test /Positive Test=========================================================================================
	@Test
	public void testCreateUser_WhenDetailsProvide_returnUserObject() {
		//Arrange
//		UserService userService = new UserServiceImpl();
//		String firstName = "Intan";
//		String lastName  = "Juniar";
//		String email     = "Intan.juniar@gmail.com";
//		String password  = "cacicuce";
//		String repeatPassword = "lalalalo";
		
		//Act
		User user = userService.createUser(firstName, lastName, email, password, repeatPassword);
		
		//Assert
		assertNotNull(user, "if creat user succes not return null");
		assertEquals(firstName, user.getFirstName(), "User first name is incorrect");
		assertEquals(lastName, user.getLastName(), "User last name is incorrect");
		assertEquals(email, user.getEmail(), "User email is incorrect");
		assertNotNull(user.getId(), "User id cannot null");
	}

//	Red Test/Negative Test=========================================================================================
	@DisplayName("Empty first name cause exception")
	@Test
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException() {
		//Arrange
		String firstName = "";
		String exceptedExceptionMessage = "User First Name is Empty";
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstName, lastName, email, password, repeatPassword);
		}, "Empty first name cause Illegal Argument Exception");
		
		
		//Assert
		assertEquals(exceptedExceptionMessage, thrown.getMessage());
	}
	
//	Red Test/Negative Test=========================================================================================
	@DisplayName("Empty last name cause exception")
	@Test
	public void testCreateUser_WhenLastNameEmpty_ThrowsIllegalException() {
		//Arrange
		String lastName = "";
		String exceptedExceptionMessage = "User Last Name is Empty";
						
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstName, lastName, email, password, repeatPassword);
		}, "Empty last name cause Illegal Argument Exception");
			
		//Assert
		assertEquals(exceptedExceptionMessage, thrown.getMessage());
	}
			
	
}
