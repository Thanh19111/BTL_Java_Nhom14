package employeeManagementTest;

import Model.Employee;
import Model.EmployeeManagement;

public class EmployeeManagement_Main {
		
		private EmployeeManagement em;
		
		public EmployeeManagement_Main() {
			this.em = new EmployeeManagement();
		}

		public int addEmployee(String id, String name, String bỉrthDate, String gender, String homeTown, String phoneNumber, 
								String hỉreDate, String overTimeHour, String positionName, String departmentName) {
			Employee employee = new Employee();
			int res = employee.input(id, name, bỉrthDate, gender, homeTown, phoneNumber, hỉreDate, overTimeHour, 
										positionName, departmentName);
			if (res == 1) return 1;
			else if (res == 2) return 2;
			else if (res == 3) return 3;
			else if (res == 4) return 4;
			return em.addEmployee(employee);
		}
				
		public int removeEmployee(String id) {	
			return em.removeEmployee(Integer.parseInt(id));
		}
			
		public int editEmployee(String id, String name, String bỉrthDate, String gender, String homeTown, String phoneNumber, 
				String hỉreDate, String overTimeHour, String positionName, String departmentName) {
			int res = em.editEmployee(id, name, bỉrthDate, gender, homeTown, 
	    								phoneNumber, hỉreDate, overTimeHour, positionName, departmentName);
			return res;
		}
			
		public void displayEmployee() {
			em.employeeDisplay();
		}
		
}