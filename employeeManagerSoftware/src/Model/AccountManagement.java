package Model;
import java.util.*;


import Utils.Utils;
import Data.DatabaseConnection;

public class AccountManagement {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public AccountManagement() {
        loadAccounts();
    }

    public void loadAccounts() {
    	accounts.clear();
        accounts = DatabaseConnection.AccountQuery("select * from Account");
    }


    public void addAccount(String username, String password) {
    	username = Utils.encrypt(username.trim());
    	password = Utils.encrypt(password.trim());
    	
        String sql = "EXECUTE AddAccount " + username + ", N'" + password +"'";
        DatabaseConnection.AccountExecProc(sql);
        System.out.println("Thêm tài khoản thành công!");
    }

    public int removeAccount(String username) {
    	username = Utils.encrypt(username.trim());
    	
    	if (username == null || username.isEmpty()) return 3;
    	
    	for(Account i : this.getAccounts())
    	{
    		if(i.getUsername().equals(username))
    		{
    			String sql = "EXECUTE DeleteAccount " + "N'" + username +"'";
    	        DatabaseConnection.AccountExecProc(sql);
    	        System.out.println("Xóa tài khoản thành công!");
    	        return 2;
    		}
    		
    	}
    	return 1;
    }

    public int editAccount(String username, String newPassword) {
    	username = Utils.encrypt(username.trim());
    	newPassword = Utils.encrypt(newPassword.trim());
    	
    	if (username == null || username.isEmpty()) return 3;
    	if (newPassword == null || newPassword.isEmpty()) return 4;
    	
    	for(Account acc : this.getAccounts())
    	{
    		if(acc.getUsername().equals(username))
    		{
    			String sql = "EXECUTE UpdateAccount " + "N'" + username +"' ," + " N'" + newPassword +"'";
    			DatabaseConnection.AccountExecProc(sql);
    			System.out.print("Sửa tài khoản thành công");
    			return 2;
    		}
    	}
    	return 1;
    }

    public void AccountsDisplay() {
        loadAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Không có tài khoản nào trong hệ thống.");
        } else {
            System.out.println("Danh sách tài khoản:");
            for (Account account : accounts) {
                System.out.println(account.toString());
            }
        }
    }
    
    public ArrayList<Account> getAccounts() {
        return DatabaseConnection.AccountQuery("select * from Account");
    }
}