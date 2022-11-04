package telran.user.model;

import java.util.Iterator;

public class User {
	private String email;
	private String password;

	public User(String email, String password) {
		setEmail(email);
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (validate(email)) {
			this.email = email;
		} else {
			System.out.println(email + " is not valid");
		}
	}

	/*
	 * 1) exists @ and only one -> Done
	 * 2) exist dot after @ -> Done
	 * 3) after last dot min 2 symbols -> Done
	 * 4) correct symbols: digits, alphabet, '_', '-', '.', '@' -> Done
	 */
	private boolean validate(String email) {
		int indexAt = email.indexOf('@');
		if(indexAt == -1 || indexAt != email.lastIndexOf('@')) {
			return false;
		}
		if(email.indexOf('.', indexAt) == -1) {
			return false;
		}
		if(email.lastIndexOf('.') >= email.length() - 2) {
			return false;
		}
		for(int i = 0; i < email.length(); i++) {
			char c = email.charAt(i);
			if(!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '_'
					|| c == '-' || c == '.' || c == '@')) {
				return false;
			}
		}
		return true;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * 1) min 8 symbols
	 * 2) min one symbol in upperCase
	 * 3) min one symbol in lowerCase
	 * 4) min one digit
	 * 5) min one special symbol (!%@*&)
	 */
	private boolean validatePassword(String password) {
		if (password.length() < 8) //min 8 symbols if not - return false
		{
			return false;
		}
		
		int upperCaseCount = 0, digitCount=0, lowerCaseCount=0, specialSymbolCount = 0;
		
		for (int i = 0; i < password.length(); i++) {
			char letter = password.charAt(i);
			
			
			if(Character.isUpperCase(letter)) {
				upperCaseCount++;
			}	
			
			if(Character.isLowerCase(letter))
			{
				lowerCaseCount++;
			}
			
			if(Character.isDigit(letter))
			{
				digitCount++;
			}
			if(letter == '!' || letter == '%' || letter == '@' || letter == '*' || letter == '&')
			{
				specialSymbolCount++;
			}
		}
		if(upperCaseCount>0 && digitCount>0 && lowerCaseCount>0 && specialSymbolCount>0)
		{
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	

	public void setPassword(String password) {
		if (validatePassword(password)) 
		{
		this.password = password;
		}
		else {
			System.out.println(password + " this password is not valid");
		}
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

}
