package Model;

import java.util.ArrayList;
import java.util.Scanner;

import Utils.Utils;

public class Account {

    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {}
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void nhap(Scanner sc) {
        while (true) {
            try {
                System.out.print("Nhập tên tài khoản: ");
                setUsername(sc.nextLine());
                System.out.print("Nhập mật khẩu: ");
                setPassword(sc.nextLine());
                break;
            } 
            catch (Exception e) {
                System.out.println(e.toString());;
            }
            
        }

    }

    @Override
    public String toString() {
        return username + "," + password;
    }

    // Static methods to handle registration and login
    public static int register(ArrayList<Account> accounts, String username, String password) 
    {
    	username = Utils.encrypt(username.trim());
    	password = Utils.encrypt(password.trim());
    	
    	if (username == null || username.isEmpty()) return 3;
    	if (password == null || password.isEmpty()) return 4;
    	for(Account account : accounts)
    	{
    		if(account.getUsername().equals(username))
    		{
    			return 1;
    		}
    	}
    	
        return 2;
    }

    public static int login(ArrayList<Account> accounts, String username, String password) {
    	username = Utils.encrypt(username.trim());
    	password = Utils.encrypt(password.trim());
    	
        if (username == null || username.isEmpty()) return 4;
    	if (password == null || password.isEmpty()) return 5;
    	
    	for(Account acc : accounts)
    	{
    		if(acc.getUsername().equals(username))
    		{
    			if (acc.getPassword().equals(password)) {
    	            return 2;
    	        } else {
    	            return 3;
    	        }
    		}
    		
    	}
    	return 1;
    }
}