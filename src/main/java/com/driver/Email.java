package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
    	if(password.equals(oldPassword) && passwordCondition(newPassword)) {
    		password = newPassword;
    	}
    }
    
    private boolean passwordCondition(String newPassword) {
    	
    	// 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    	boolean upperCase = false;
    	boolean lowerCase = false;
    	boolean digit = false;
    	boolean specialCharacter = false;
    	
    	for(int i=0 ; i<newPassword.length() ; i++) {
    		char c = newPassword.charAt(i);
    		if(c >= 'a' && c <= 'z') lowerCase = true;
    		else if (c >= 'A' && c <= 'Z') upperCase = true;
    		else if(c >= '0' && c <= '9') digit = true;
    		else specialCharacter = true;
    	}
    	
    	return newPassword.length() >= 8 && upperCase && lowerCase && digit && specialCharacter;
    }
}
