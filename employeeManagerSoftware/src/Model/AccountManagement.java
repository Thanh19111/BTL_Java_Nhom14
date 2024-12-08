package Model;

import java.io.*;
import java.util.*;

public class AccountManagement {
    private static final String FILE_NAME = "D:\\Account.txt";
    private Map<String, Account> accounts;

    public AccountManagement() {
    	accounts = new HashMap<>();
        loadAccounts();
    }

    public void loadAccounts() {
    	accounts.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    accounts.put(parts[0], new Account(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể đọc file tài khoản.");
        }
    }

    public void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account account : accounts.values()) {
                writer.write(account.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Không thể lưu file tài khoản.");
        }
    }

    public void addAccount(String username, String password) {
        if (accounts.containsKey(username)) {
            System.out.println("Tài khoản đã tồn tại.");
            return;
        }
        accounts.put(username, new Account(username, password));
        saveAccounts();
        System.out.println("Thêm tài khoản thành công!");
    }

    public int removeAccount(String username) {
    	if (username == null || username.trim().isEmpty()) return 3;
        if (!accounts.containsKey(username)) return 1;
        accounts.remove(username);
        saveAccounts();
        return 2;
    }

    public int editAccount(String username, String newPassword) {
    	if (username == null || username.trim().isEmpty()) return 3;
    	if (newPassword == null || newPassword.trim().isEmpty()) return 4;
        Account account = accounts.get(username);
        if (account == null) return 1;
        else {
        	account.setPassword(newPassword);
            saveAccounts();
            return 2;
        }
    }

    public void AccountsDisplay() {
        loadAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Không có tài khoản nào trong hệ thống.");
        } else {
            System.out.println("Danh sách tài khoản:");
            for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                System.out.println(entry.getValue().toString());
            }
        }
    }
    
    public Map<String, Account> getAccounts() {
        return accounts;
    }
}