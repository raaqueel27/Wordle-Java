package wordle;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class User {
    
    private String name;
    private String password;
    private boolean validPassword;
    private Scanner input = new Scanner(System.in);
    private int score = 0;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        validPassword = false;
        while(!validPassword) {
            for(int i = 0; i < this.password.length(); i++) {
                char c = this.password.charAt(i);
                int comparison = Character.compare(Character.toUpperCase(c),c);
                if(comparison == 0 && password.length() >= 8) {
                    validPassword = true;
                }
            }
            if(!validPassword) {
                return;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public static boolean passwordIsValid(String password) {
    	boolean validPassword = false;
    	for(int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            int comparison = Character.compare(Character.toUpperCase(c),c);
            if(comparison == 0) {
                validPassword = true;
            }
        }
    	if(password.length() >= 8 ) {
    		validPassword = true;
    	} else {
    		validPassword = false;
    	}
    	if(validPassword) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean checkPassword(User user,String password) {
    	FileManagment fm = new FileManagment();
    	User correctUser = fm.getPlayer(user.getName());
    	String correctPassword = correctUser.getPassword();
    	if(password.equals(correctPassword))
    		return true;
    	else
    		return false;
    }
    
    
    
}