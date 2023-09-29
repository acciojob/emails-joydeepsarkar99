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

    public void setPassword(String password) {
        this.password = password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecial = false;
        boolean isLength = false;
        if(oldPassword.equals(getPassword())){
            if(newPassword.length() == 8) isLength = true;
            for(int i=0;i<newPassword.length();i++){
                char c = newPassword.charAt(i);
                if(Character.isUpperCase(c)) isUpperCase = true;
                if(Character.isLowerCase(c)) isLowerCase = true;
                if(Character.isDigit(c)) isDigit = true;
                if(!Character.isDigit(c) && !Character.isUpperCase(c) && !Character.isLowerCase(c)) isSpecial = true;
            }
            if(isLength && isUpperCase && isLowerCase && isDigit && isSpecial){
                setPassword(newPassword);
            }
        }
    }
}
