package ReportTest;

import Model.Report;

public class Report_Main {
		
		private Report rp;
		
		public Report_Main() {
			this.rp = new Report();
		}

		public int total_Employee() {
				return rp.totalEmployee();
			}
			
		public void total_EmployeeByPosition() {
				rp.totalEmployeeByPosition();
			}
			
		public void salaryBy_Postion() {
				rp.salaryByPosition();
		}
		
}