package AccountManagementTest;

import java.util.Scanner;

import Model.Account;
import Model.AccountManagement;

public class AccountManagement_Main {

    	private AccountManagement accountManager;
        Scanner scanner = new Scanner(System.in);

        
        public AccountManagement_Main() {
        	this.accountManager = new AccountManagement();
		}

		public int signUp(String username, String password) {
            int res = Account.register(accountManager.getAccounts(), username, password);
            if (res == 2) {
            	accountManager.addAccount(username, password);
            	return 2;
            }
            return res;
        }
           
        public int login(String userName, String password) {
            return Account.login(accountManager.getAccounts(), userName, password);
        }
        
        public void addNewAccount() {
        	Account acc3 = new Account();
            acc3.nhap(scanner);
            accountManager.addAccount(acc3.getUsername(), acc3.getPassword());
        }
        
        public int removeAccount(String username) {
            return accountManager.removeAccount(username);
        }            
        
        public int editAccount(String userName, String newPassword) {
				return accountManager.editAccount(userName, newPassword);
        }  
                        
        public void displayAccount() {
        	accountManager.AccountsDisplay();
        }

		
        
}
    