package service;

import java.util.UUID;

import model.User;

public class UserServiceImpl implements UserService{

	public User createUser(String firstName, String lastName, String email, String password, String resetPassword) {
		// TODO Auto-generated method stub
		if(firstName == null || firstName.trim().length()==0) {
			throw new IllegalArgumentException("User First Name is Empty");
		}
		
		if(lastName == null || lastName.trim().length()==0) {
			throw new IllegalArgumentException("User Last Name is Empty");
		}
		
		return new User(firstName, lastName, email, UUID.randomUUID().toString());
	}
	public void Test() {
		
	}
	
//	@Override
//	public void addAttachment() {
//		File file = new File();
//		file.createAttachment();
//	}
//	
//	@Override
//	public void sendEmail() {
//		Sendmail mail = new Sendmail();
//		mail.sendMail();
//	}
}
