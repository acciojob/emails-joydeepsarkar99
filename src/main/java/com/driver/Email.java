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
        //Change password only if the oldPassword is equal to current password and the new password meets all the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(password)){
            if (isValid(newPassword)) {
                System.out.println("Password changed successfully");
                this.password = newPassword;
            }
            else System.out.println("Password is not valid");
        }
        else{
            System.out.println("Password mismatch");
        }

    }
    private boolean isValid(String password){
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecial = false;

        if(password.length() < 8) return false;

        for(int i=0;i<password.length();i++){
            char c = password.charAt(i);
            if(Character.isUpperCase(c)) isUpperCase = true;
            else if(Character.isLowerCase(c)) isLowerCase = true;
            else if(Character.isDigit(c)) isDigit = true;
            else isSpecial = true;
        }
        if(isUpperCase && isLowerCase && isDigit && isSpecial) return true;
        return false;
    }
}
