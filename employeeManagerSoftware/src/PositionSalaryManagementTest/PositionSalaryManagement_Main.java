package PositionSalaryManagementTest;

import Model.PositionSalaryManagement;

public class PositionSalaryManagement_Main {
		
		private PositionSalaryManagement psm;

		public PositionSalaryManagement_Main() {
			this.psm = new PositionSalaryManagement();
		}

		public int editSalary(String id, String salary) {
				return psm.positionSalaryEdit(id, salary);
		}
}