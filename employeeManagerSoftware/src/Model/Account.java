package Model;

import java.util.Map;
import java.util.Scanner;

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
    public static int register(Map<String, Account> accounts, String username, String password) {
    	if (username == null || username.trim().isEmpty()) return 3;
    	if (password == null || password.trim().isEmpty()) return 4;
    	if (accounts.containsKey(username)) {
            return 1;
        } 
        else {
            accounts.put(username, new Account(username, password));
            return 2;
        }
    }

    public static int login(Map<String, Account> accounts, String username, String password) {
        Account account = accounts.get(username);
        if (username == null || username.trim().isEmpty()) return 4;
    	if (password == null || password.trim().isEmpty()) return 5;
        if (account == null) {
            return 1;
        }
        if (account.getPassword().equals(password)) {
            return 2;
        } else {
            return 3;
        }
    }
}