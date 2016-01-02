import java.util.Scanner;
/**
 * Logins
 * @author: Jacob Silverman, js6135
 * tutoring at computer lab
 */

@SuppressWarnings("resource")
public class Logins {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		// Asking for user to input user name
		System.out.println("Please enter your username: ");
		String username = input.nextLine();

		// gets rid of all the spaces in user name
		username.replaceAll("//s+", "");
		

		
		// checking make sure all conditions have been met before assigning a user name
		while (usernameChecker(username) == false) {
			if (usernameChecker(username) == false) {
				System.out.println("Your username did not satisfy the requirements: \n" +
						"it must be at least 4 characters long, and less than 16 characters long, \n" +
						" and there can not be a digit at the begining.");
				username = input.nextLine();
			}
		}
		
		// notifying the user that his/her user name will work
		if (usernameChecker(username) == true) {
			System.out.println("You have satisified the requirements your username will work");
		}
		
		// Asking for user to input password
		System.out.println("Please enter your password: ");
		String password = input.nextLine();
		
		// gets rid of all the spaces in password
		password.replaceAll("//s+", "");
		
		// checking make sure all conditions have been met before assigning a user password
		while(passwordChecker(password, username) == false || 
			passwordUpper(password) == false || 
			passwordLower(password) == false ||
			passwordNumeric(password) == false) {

			System.out.println("Your password did not satisfy the requirements: \n " +
					"needs to be 8 letters long, contain an uppercase letter, a lowercase, \n" +
					"and least one number, and cant contain the username");
			password = input.nextLine();
			}
		
		// notifying the user that his/her user password will work
		if (passwordChecker(password, username) == true &&
				passwordUpper(password) == true && 
				passwordLower(password) == true &&
				passwordNumeric(password) == true) {
			
			System.out.println("You have satisfied the requirements your password will work");
		}
	}
	
	/**
	 * Checks to see if the user name inputed is 4 letters
	 * or more but less than 16. Also checks if the String
	 * does not starts with a digit. If any of these condition
	 * are not apart of user name then the method returns false.
	 * 
	 * @param username user input
	 * @return true or false
	 */
	public static boolean usernameChecker(String username) {
		
		if (username.length() < 4 || username.length() >= 16) {
			return false;
		} else if (Character.isDigit(username.charAt(0))) {
			return false;
		} else {
			return true;
		}	
	}
	
	/**
	 * Checks to see if user name is within the password
	 * and if password is less than 8 letters long. If either
	 * of these conditions are not met then the method returns
	 * false.
	 * 
	 * @param password user input
	 * @param username user input
	 * @return true or false
	 */
	public static boolean passwordChecker(String password, String username) {
		
		if (password.contains(username)) {
			return false;
		} else if (password.length() < 8) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Additional check on password to make sure
	 * that the password contains at least one 
	 * upper case letter.
	 * 
	 * @param password user input
	 * @return true or false
	 */
	public static boolean passwordUpper(String password) {
		
		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				return true;
				
			} 
		}
		return false;
	}
	
	
	/**
	 * Additional check on password to make sure
	 * that the password contains at least one 
	 * lower case letter.
	 * 
	 * @param password user input
	 * @return true or false
	 */
	public static boolean passwordLower(String password) {
		
		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				return true;
				
			} 
		}
		return false;
	}
	
	/**
	 * Additional check on password to make sure
	 * that the password contains at least one 
	 * numeric 0-9.
	 * 
	 * @param password user input
	 * @return true or false
	 */
	public static boolean passwordNumeric(String password) {

		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				return true;
				
			} 
		}
		return false;
	}

}
