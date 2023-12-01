package day4.beans;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class UserValidate {
	public static boolean isValid(User currentUser) {
		boolean success = false;
		
		String username = currentUser.getUsername();
		String password = currentUser.getPassword();
		
		if(username.equals("admin") && password.equals("abcde@123")) {
			success = true;
		}
		
		return success;
	}
}
