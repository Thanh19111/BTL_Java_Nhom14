package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PositionManagement_View;

public class PositionViewListener implements ActionListener{

	private PositionManagement_View pmv;
	
	public PositionViewListener(PositionManagement_View pmv) {
		this.pmv = pmv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pmv.position_search();
	}

}
